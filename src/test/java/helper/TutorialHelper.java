package helper;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class TutorialHelper {
    private AndroidDriver driver;

    public TutorialHelper(AndroidDriver driver) {
        this.driver = driver;
    }

//    @FindBy(id = "id/select_team_container")
//    public SelenideElement teamViewLocator;
//
//    @FindBy(id = "id/start_bet_info")
//    public SelenideElement startBetInfoButtonLocator;

    private String startBetInfoButtonName = "SHOW ME HOW IT WORKS";
    private By startBetInfoButtonLocator = By.id("id/start_bet_info");
    private By teamViewLocator = By.id("id/select_team_container");
    private By locationViewLocator = By.id("id/select_location_container");
    private By playerViewLocator = By.id("id/select_player_container");
    private By leftTeamIconLocator = By.id("id/tv_left_team_icon");
    private By leftTeamNameLocator = By.id("id/tv_team_left_name");
    private By leftTeamBonusLocator = By.id("id/tv_team_left_bonus");
    private By rightTeamIconLocator = By.id("id/tv_right_team_icon");
    private By rightTeamNameLocator = By.id("id/tv_team_right_name");
    private By rightTeamBonusLocator = By.id("id/tv_team_right_bonus");
    private By gameFieldLocator = By.id("id/game_field");
    private By nextButtonLocator = By.name("Next");

    public WebElement startBetInfoButton() {
        return $(startBetInfoButtonLocator);
    }

    public WebElement nextButton() {
        return $(nextButtonLocator);
    }

    public void assertTutorialTeamPage() {
        assertTrue("Tutorial team page wasn't shown", $(teamViewLocator).isDisplayed());
        assertTrue("Left team icon text wasn't shown on the tutorial team page", $(leftTeamIconLocator).isDisplayed());
        assertTrue("Left team name text wasn't shown on the tutorial team page", $(leftTeamNameLocator).isDisplayed());
        assertTrue("Left team bonus text wasn't shown on the tutorial team page", $(leftTeamBonusLocator).isDisplayed());
        assertTrue("Right team icon text wasn't shown on the tutorial team page", $(rightTeamIconLocator).isDisplayed());
        assertTrue("Right team name text wasn't shown on the tutorial team page", $(rightTeamNameLocator).isDisplayed());
        assertTrue("Right team bonus text wasn't shown on the tutorial team page", $(rightTeamBonusLocator).isDisplayed());
    }

    public void assertTutorialPlayerPage() {
        assertTrue("Tutorial player page wasn't shown", $(playerViewLocator).isDisplayed());
    }

    public void assertTutorialGameFieldPage() {
        assertTrue("Tutorial game field location page wasn't shown", $(locationViewLocator).isDisplayed());
        assertTrue("Game field location wasn't shown", $(gameFieldLocator).isDisplayed());
    }

}
