package helper.tabs;

import helper.BaseHelper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TabsHelper extends BaseHelper {
    private By gamesTabLocator = By.id("com.vivalasport.hoopit:id/nav_games");
    private By homeTabLocator = By.id("com.vivalasport.hoopit:id/nav_home");

    public TabsHelper openGamesTab() {
        waiter();
        $(gamesTabLocator).click();
        return this;
    }

    public TabsHelper openHomeTab() {
        $(homeTabLocator).click();
        return this;
    }
}
