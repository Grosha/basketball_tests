package helper.tabs.games;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LiveGameHelper {
    private By indoorTeamScoreLocator = By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView");
    private By outdoorTeamScoreLocator = By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView");
    private By numberPicksLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.vivalasport.hoopit:id/left_container']/android.widget.TextView[2]");
    private By pickTitleLocator = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.vivalasport.hoopit:id/bet_list']//android.widget.TextView");
    private By timePickLocator = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.vivalasport.hoopit:id/bet_list']//android.widget.TextView[2]");
    private By gameTimeLocator = By.xpath("//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]//android.widget.TextView");
    private By makePickButtonLocator = By.id("com.vivalasport.hoopit:id/next_pick");

    public String getScoreInLiveGame() {
        return $(indoorTeamScoreLocator).getText() + " : " + $(outdoorTeamScoreLocator).getText();
    }

    public int geNumberPicks() {
        return Integer.parseInt($(numberPicksLocator).getText());
    }

    public void clickMakePickButton() {
        $(makePickButtonLocator).click();
    }

    public String getGameTime() {
        ElementsCollection timeComponentList = $$(makePickButtonLocator);
        return timeComponentList.get(2) + " : " + timeComponentList.get(4);
    }

    public void assertPresencePickInHistory(String teamName, int numberPicks, String gameTime) {
        SoftAssert asert = new SoftAssert();
        asert.assertEquals($(pickTitleLocator).getText(), teamName.concat(" TO SCORE"), "lala");
        asert.assertTrue(Integer.parseInt($(numberPicksLocator).getText()) - numberPicks == 1);
        asert.assertTrue($(timePickLocator).getText().contains(gameTime));
        asert.assertAll();
    }
}
