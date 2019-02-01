package helper.tabs.games;

import helper.Helpers;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LiveGameBlockHelper {
    private By leftTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_left_name");
    private By leftTeamIconLocator = By.id("com.vivalasport.hoopit:id/ic_left_team_icon");
    private By rightTeamIconLocator = By.id("com.vivalasport.hoopit:id/ic_right_team_icon");
    private By rightTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_right_name");
    private By liveMarkLocator = By.id("com.vivalasport.hoopit:id/tv_live_mark");
    private By quaterNumberLocator = By.id("com.vivalasport.hoopit:id/tv_info");
    private By scoreLocator = By.id("com.vivalasport.hoopit:id/score");

    public void assertLiveGameElementsPresence() {
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(leftTeamIconLocator).isDisplayed(), "Left Team icon wasn't shown");
        asert.assertTrue($(leftTeamNameLocator).isDisplayed(), "Left Team name wasn't shown");
        asert.assertTrue($(rightTeamIconLocator).isDisplayed(), "Right Team icon wasn't shown");
        asert.assertTrue($(rightTeamNameLocator).isDisplayed(), "Right Team name wasn't shown");
        asert.assertTrue($(liveMarkLocator).isDisplayed(), "Live mark locator wasn't shown");
        asert.assertTrue($(quaterNumberLocator).isDisplayed(), "Quater namber wasn't shown");
        asert.assertTrue($(scoreLocator).isDisplayed(), "Score wasn't shown");
        asert.assertAll();
    }

    public void assertOpenedNBALeague() {
        assertTrue($(quaterNumberLocator).getText().contains("Q"), "There is presenting incorrect game in NBA league");
    }

    public void assertOpenedNCAALeague() {
        assertTrue($(quaterNumberLocator).getText().contains("H"), "There is presenting incorrect game in NCAA league");
    }

    public LiveGameBlockHelper enterToTheLiveGame() {
        $(leftTeamIconLocator).click();
        return this;
    }

    public String getScoreInBlockLiveGame() {
        return $(scoreLocator).getText();
    }

    public String getIndoorTeamName() {
        return $(leftTeamNameLocator).getText();
    }

    public void assertScoreInLiveBlockAndLiveGame() {
        String score = getScoreInBlockLiveGame();
        enterToTheLiveGame();
        assertEquals(score , Helpers.liveGame().getScoreInLiveGame());
    }
}
