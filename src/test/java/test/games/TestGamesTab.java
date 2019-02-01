package test.games;

import com.codeborne.selenide.WebDriverRunner;
import helper.Helpers;
import helper.tabs.games.*;
import helper.tabs.home.HomeTabHelper;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.BaseTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestGamesTab extends BaseTest {

    private AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        driver = new AndroidDriver(new URL(APPIUM_HOST), capabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
        Helpers.tabs().openGamesTab();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLeaguesName() {
        Helpers.games().assertLeaguesTabName();
    }

    @Test
    public void testSortingNBALeague() {
        Helpers.games().selectNBALeague();
        Helpers.liveGameBlock().assertOpenedNBALeague();
    }

    @Test
    public void testSortingNCAALeague() {
        Helpers.games().selectNCAALeague();
        Helpers.liveGameBlock().assertOpenedNCAALeague();
    }

    @Test
    private void testLiveGameBlock() {
        Helpers.games().selectNBALeague();
        Helpers.liveGameBlock().assertLiveGameElementsPresence();
    }
}
