package test.games;

import com.codeborne.selenide.WebDriverRunner;
import helper.LoginView;
import helper.TutorialHelper;
import helper.popup.CongratsPopup;
import helper.popup.InviteFriendsPopup;
import helper.tabs.games.*;
import helper.tabs.home.HomeTabHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestGamesTab extends BaseTest {

    private AndroidDriver driver;
    private GamesTabHelper gamesTab = new GamesTabHelper();
    private HomeTabHelper homeTab = new HomeTabHelper();
    private LiveGameBlockHelper liveGameBlock = new LiveGameBlockHelper();

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
    public void testLeaguesName() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.assertLeaguesTabName();
    }

    @Test
    public void testSortingNBALeague() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
        liveGameBlock.assertOpenedNBALeague();
    }

    @Test
    public void testSortingNCAALeague() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNCAALeague();
        liveGameBlock.assertOpenedNCAALeague();
    }

    @Test
    private void testLiveGameBlock() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
        liveGameBlock.assertLiveGameElementsPresence();
    }
}
