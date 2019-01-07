package helper.popup;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

public class CongratsPopup extends BasePopup {
    private By congratulationTextLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");
    private By grantBonusCoinsLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");
    private By startPredictingButtonLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");

    public void assertPresenceElements() {
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(congratulationTextLocator).isDisplayed(), "Text for congrats wasn't shown");
        asert.assertTrue($(grantBonusCoinsLocator).isDisplayed(), "Bonus coins after sign up wasn't shown");
        asert.assertTrue($(startPredictingButtonLocator).isDisplayed(), "Button Start Prediction wasn't shown");
        asert.assertAll();
    }

    public void clickStartPredictingButton() {
        $(startPredictingButtonLocator).click();
    }
}
