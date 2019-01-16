package test;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestMy extends SetUpCapabilities{
    private AndroidDriver driver;
    private TutorialHelper tutorialHelper = new TutorialHelper();
    private LoginView loginHelper = new LoginView();
    private InviteFriendsPopup inviteFriendsPopup = new InviteFriendsPopup();
    private CongratsPopup congratsPopup = new CongratsPopup();
    private GamesTabHelper gamesTab = new GamesTabHelper();
    private HomeTabHelper homeTab = new HomeTabHelper();
    private LiveGameBlockHelper liveGameBlock = new LiveGameBlockHelper();
    private LiveGameHelper liveGameHelper = new LiveGameHelper();
    private LiveBetTeamHelper betTeamHelper = new LiveBetTeamHelper();
    private LiveBetPlayerHelper betPlayerHelper = new LiveBetPlayerHelper();

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

    @Test
    public void testLoginNewUser() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        loginHelper.loginAs("qa test", loginHelper.getNewEmail(), loginHelper.getPassword());
        wait.until(ExpectedConditions.visibilityOfElementLocated(inviteFriendsPopup.profileImage()));
        inviteFriendsPopup.assertInviteFriendsPopupOpend();
        inviteFriendsPopup.closePopup();
        congratsPopup.assertPresenceElements();
        congratsPopup.clickStartPredictingButton();
    }

    @Test
    public void testLeaguesName() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.assertLeaguesTabName();
    }

    @Test
    public void testSortingNBALeague() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
        liveGameBlock.assertOpenedNBALeague();
    }

    @Test
    public void testSortingNCAALeague() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
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

    @Test
    public void assertScoreInLiveBlockAndLiveGame() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
        String score = liveGameBlock.getScoreInBlockLiveGame();
        liveGameBlock.enterToTheLiveGame();
        assertEquals(score , liveGameHelper.getScoreInLiveGame());
    }

    @Test
    public void testCreateLiveTeamBet() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTab.getHomeTab()));
        gamesTab.openGamesTab();
        gamesTab.selectNBALeague();
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
}