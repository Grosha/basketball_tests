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

public class TestMy extends SetUpCapabilities{
    private AndroidDriver driver;
    private TutorialHelper tutorialHelper = new TutorialHelper();
    private LoginView loginView = new LoginView();

    @BeforeMethod
    public void setup() throws Exception {
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), getCapabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testFirst() {
        tutorialHelper.clickStartBetInfoButton();
        tutorialHelper.assertTutorialTeamPage();
        tutorialHelper.assertTutrialPlayersPage();
        tutorialHelper.assertTutorialGameFieldPage();
        tutorialHelper.clickOnGameField();
        loginView.assertOpenedLoginView();
    }
}
