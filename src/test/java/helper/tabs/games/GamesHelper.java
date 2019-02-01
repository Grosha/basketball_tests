package helper.tabs.games;

import com.codeborne.selenide.ElementsCollection;
import helper.BaseHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamesTabHelper  extends BaseHelper {
    private By gamesTabLocator = By.id("com.vivalasport.hoopit:id/nav_games");
    private By gameListLocator = By.id("com.vivalasport.hoopit:id/game_list");
    private By leagueListLocator = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.vivalasport.hoopit:id/league_list']//android.widget.TextView");

    public GamesTabHelper openGamesTab() {
        waiter();
        $(gamesTabLocator).click();
        return this;
    }

    public GamesTabHelper selectNBALeague() {
        $$(leagueListLocator).get(1).click();
        return this;
    }

    public GamesTabHelper selectNCAALeague() {
        $$(leagueListLocator).get(2).click();
        return this;
    }

    public void assertLeaguesTabName() {
        ElementsCollection leaguesList = $$(leagueListLocator);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(leaguesList.get(0).getText().equals("ALL"), "ALL tab in league absent");
        asert.assertTrue(leaguesList.get(1).getText().contains("NBA"), "ALL tab in league absent");
        asert.assertTrue(leaguesList.get(2).getText().contains("NCAA"), "ALL tab in league absent");
        asert.assertAll();
    }
}
