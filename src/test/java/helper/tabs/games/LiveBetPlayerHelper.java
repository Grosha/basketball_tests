package helper.tabs.games;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LiveBetPlayerHelper {
    private By finishBetLocator = By.id("com.vivalasport.hoopit:id/next_pick");

    public void finishBet() {
        $(finishBetLocator).click();
    }
}
