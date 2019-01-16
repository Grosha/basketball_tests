package helper.tabs.games;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LiveBetTeamHelper {
    private By leftTeamLocator = By.id("com.vivalasport.hoopit:id/left_team");
    private By leftTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_left_name");
    private By rightTeamLocator = By.id("com.vivalasport.hoopit:id/right_team");
    private By rightTeamNameLocator = By.id("com.vivalasport.hoopit:id/tv_team_right_name");

    public void doLeftTeamBet() {
        $(leftTeamLocator).click();
    }

}
