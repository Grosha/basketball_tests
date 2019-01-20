package test.games;

import com.codeborne.selenide.WebDriverRunner;
import helper.ToolbarHelper;
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestInGame extends BaseTest {

    private AndroidDriver driver;
    private GamesTabHelper gamesTab = new GamesTabHelper();
    private HomeTabHelper homeTab = new HomeTabHelper();
    private LiveGameBlockHelper liveGameBlock = new LiveGameBlockHelper();
    private LiveGameHelper liveGameHelper = new LiveGameHelper();
    private LiveBetTeamHelper betTeamHelper = new LiveBetTeamHelper();
    private LiveBetPlayerHelper betPlayerHelper = new LiveBetPlayerHelper();
    private ToolbarHelper toolbarHelper = new ToolbarHelper();

    @BeforeMethod
    public void setup() throws Exception {
        driver = new AndroidDriver(new URL(APPIUM_HOST), capabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void assertScoreInLiveBlockAndLiveGame() {
//        gamesTab.selectNBALeague();
        String score = liveGameBlock.getScoreInBlockLiveGame();
        liveGameBlock.enterToTheLiveGame();
        assertEquals(score , liveGameHelper.getScoreInLiveGame());
    }

    @Test
    public void testCreateLiveTeamBet() {
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
//        gamesTab.openGamesTab();
//        gamesTab.selectNBALeague();
        String indoorTeamName = liveGameBlock.getIndoorTeamName();
        liveGameBlock.enterToTheLiveGame();
        int numberPicks = liveGameHelper.geNumberPicks();
        String gameTime = liveGameHelper.getGameTime();
        liveGameHelper.clickMakePickButton();
        betTeamHelper.doLeftTeamBet();
        betPlayerHelper.finishBet();
        driver.navigate().back();
        liveGameHelper.assertPresencePickInHistory(indoorTeamName.toUpperCase(), numberPicks, gameTime);
    }

    public void testCoinsAfterCreateTeamBet() {
        int userCoins = toolbarHelper.getUserCoins();
        liveGameBlock.enterToTheLiveGame();
        liveGameHelper.clickMakePickButton();
        betTeamHelper.doLeftTeamBet();
        betPlayerHelper.finishBet();
        assertTrue(userCoins - toolbarHelper.getUserCoins() == 20);
    }
}
