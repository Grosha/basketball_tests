package helper.popup;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CongratsPopup extends BasePopup {
    private By textsLocator = By.className("android.widget.TextView");
//    private By congratulationTextLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");
//    private By grantBonusCoinsLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");
//    private By startPredictingButtonLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");

    public void assertPresenceElements() {
        ElementsCollection listTexts = $$(textsLocator);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(listTexts.get(0).getText().equals("CONGRATS! SUCCESSFUL SIGN UP"), "Text for congrats wasn't shown");
        asert.assertTrue(listTexts.get(2).getText() != "", "Bonus coins after sign up wasn't shown");
        asert.assertTrue(listTexts.get(3).getText().equals("START PREDICTING"), "Button Start Prediction wasn't shown");
        asert.assertAll();
    }

    public void clickStartPredictingButton() {
        $$(textsLocator).get(3).click();
        assertPopupViewClosed();
    }
}
