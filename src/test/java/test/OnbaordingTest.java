package test;

import com.codeborne.selenide.WebDriverRunner;
import helper.LoginView;
import helper.TutorialHelper;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OnbaordingTest extends BaseTest{

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
}
