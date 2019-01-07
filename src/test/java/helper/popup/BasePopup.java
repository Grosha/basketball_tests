package helper.popup;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePopup {
    private By closePopupLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");

    public void closePopup() {
        $(closePopupLocator).click();
    }
}
