package test;

import com.codeborne.selenide.WebDriverRunner;
import helper.LoginView;
import helper.TutorialHelper;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestMy extends SetUpCapabilities{
    private AndroidDriver driver;
    private TutorialHelper tutorialHelper = new TutorialHelper();
    private LoginView loginHelper = new LoginView();

    @BeforeMethod
    public void setup() throws Exception {
        driver = new AndroidDriver(new URL(APPIUM_HOST), capabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testTutorial() {
        capabilities().setCapability("noReset", false);
        tutorialHelper.clickStartBetInfoButton();
        tutorialHelper.assertTutorialTeamPage();
        tutorialHelper.assertTutrialPlayersPage();
        tutorialHelper.assertTutorialGameFieldPage();
        tutorialHelper.clickOnGameField();
        loginHelper.assertOpenedLoginView();
    }

    @Test
    public void testSignup() {
//        capabilities().setCapability("noReset", true);
        tutorialHelper.clickStartBetInfoButton();
        driver.closeApp();
        driver.launchApp();
        loginHelper.assertOpenedLoginView();
    }

    @Test
    public void testCheckLogInButtonsPresence() {
        loginHelper.assertPresenceElementsOnSignUpView();
    }

    @DataProvider
    public Object[][] getNegativeCredentialData() {
        return new Object[][]{
                {"", "", "", USER_NAME_ERROR, EMAIL_ERROR, PASSWORD_ERROR},
                {"asd", "asdasd@dsf.sdf", "", null, null, PASSWORD_ERROR},
                {"asd", "", "asdsa", null, EMAIL_ERROR, null},
                {"", "asd@asd.sd", "", USER_NAME_ERROR, null, null},
                {"", "sdfsff@sdf.sdf", "sdfsg", USER_NAME_ERROR, null, null},
                {"", "", "sfdfg", USER_NAME_ERROR, EMAIL_ERROR, null},
                {"aloha", "", "", null, EMAIL_ERROR, PASSWORD_ERROR},
                {"asd", "asd", "assd", null, EMAIL_ERROR, null},
                {"asd", "asd@asd", "asd", null, EMAIL_ERROR, null},
                {"asd", "asdasd.sd", "asd", null, EMAIL_ERROR, null}
        };
    }

    @Test(dataProvider = "getNegativeCredentialData")
    public void testNegativeLogIn(String userName, String email, String password, String userNameErrorMessage, String emailErrorMessage, String passwordErrorMessage) {
        loginHelper.loginAs(userName, email, password);
        loginHelper.assertErrorMessage(userNameErrorMessage, emailErrorMessage, passwordErrorMessage);
    }

    public void testLoginNewUser() {
        loginHelper.loginAs("qa test", loginHelper.getNewEmail(), loginHelper.getPassword());
    }
}
