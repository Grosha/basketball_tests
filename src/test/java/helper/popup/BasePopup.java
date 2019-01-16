package helper.popup;

import helper.Strings;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertFalse;

public class BasePopup implements Strings {
    private By closePopupLocator = By.xpath("//android.widget.FrameLayout/android.widget.ImageView");
    private By popupViewLocator = By.id("com.vivalasport.hoopit:id/custom");

    public void closePopup() {
        $(closePopupLocator).click();
    }

    public void assertPopupViewClosed() {
        assertFalse($(popupViewLocator).isDisplayed(), "Popup view wasn't close");
    }
}
