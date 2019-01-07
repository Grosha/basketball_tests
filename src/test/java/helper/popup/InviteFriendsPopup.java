package helper.popup;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class InviteFriendsPopup extends BasePopup {
    private By actionBarRootLocator = By.id("com.vivalasport.hoopit:id/action_bar_root");
    private By profileImageLocator = By.id("com.vivalasport.hoopit:id/profile_image");

    public void assertInviteFriendsPopupOpend() {
        assertTrue($(actionBarRootLocator).isDisplayed(), "Popup for invire friends wasn't shown");
    }

}
