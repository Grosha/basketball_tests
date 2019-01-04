package helper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TutorialHelper {

    private By startBetInfoButton = By.id("com.vivalasport.hoopit:id/start_bet_intro");
    private By teamViewLocator = By.id("com.vivalasport.hoopit:id/select_team_container");
    private By locationViewLocator = By.id("com.vivalasport.hoopit:id/select_location_container");
    private By gameFieldLocator = By.id("com.vivalasport.hoopit:id/game_field");
    private By playerViewLocator = By.id("com.vivalasport.hoopit:id/select_player_container");
    private By leftTeamIconLocator = By.id("com.vivalasport.hoopit:id/ic_left_team_icon");
    private By leftTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_left_name");
    private By leftTeamBonusLocator = By.id("com.vivalasport.hoopit:id/tv_team_left_bonus");
    private By rightTeamIconLocator = By.id("com.vivalasport.hoopit:id/ic_right_team_icon");
    private By rightTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_right_name");
    private By rightTeamBonusLocator = By.id("com.vivalasport.hoopit:id/tv_team_right_bonus");
    private By teamPlayersLocator = By.xpath("//android.widget.LinearLayout//android.view.View");
    private By getAllTexts = By.xpath("//android.widget.TextView");

    public void clickStartBetInfoButton() {
        $(startBetInfoButton).click();
    }

    public void assertTutorialTeamPage() {
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(teamViewLocator).isDisplayed(), "Tutorial team page wasn't shown");
        asert.assertTrue($(leftTeamIconLocator).isDisplayed(), "Left team icon text wasn't shown on the tutorial team page");
        asert.assertTrue($(leftTeamNameLocator).isDisplayed(), "Left team name text wasn't shown on the tutorial team page");
        asert.assertTrue($(leftTeamBonusLocator).isDisplayed(), "Left team bonus text wasn't shown on the tutorial team page");
        asert.assertTrue($(rightTeamIconLocator).isDisplayed(), "Right team icon text wasn't shown on the tutorial team page");
        asert.assertTrue($(rightTeamNameLocator).isDisplayed(), "Right team name text wasn't shown on the tutorial team page");
        asert.assertTrue($(rightTeamBonusLocator).isDisplayed(), "Right team bonus text wasn't shown on the tutorial team page");
        asert.assertAll();
    }

    public void assertTutrialPlayersPage() {
        clickNextButton();

        ElementsCollection players = $$(teamPlayersLocator);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(playerViewLocator).isDisplayed(),"Tutorial players page wasn't shown");
        asert.assertEquals(players.size(), 5, "Team hasn't all players");
        asert.assertAll();
        players.get(0).click();
    }

    private void clickNextButton() {
        ElementsCollection texts = $$(getAllTexts);
        texts.get(texts.size()-1).click();
    }

    public void assertTutorialGameFieldPage() {
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(locationViewLocator).isDisplayed(), "Tutorial game field location page wasn't shown" );
        asert.assertTrue($(gameFieldLocator).isDisplayed(), "Game field location wasn't shown");
        asert.assertAll();
    }

    public void clickOnGameField() {
        $(gameFieldLocator).click();
    }
}
