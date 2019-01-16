package helper.popup;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InviteFriendsPopup extends BasePopup {
    private By inviteFriendTextLocator = By.className("android.widget.TextView");
    private By profileImageLocator = By.id("com.vivalasport.hoopit:id/profile_image");

    public By profileImage() {
        return profileImageLocator;
    }

    public void assertInviteFriendsPopupOpend() {
        SoftAssert asert = new SoftAssert();
        asert.assertEquals($(inviteFriendTextLocator).getText(), INVITE_FRIEND_TEXT_POPUP,"Texts for invire friends wasn't shown");
        asert.assertTrue($(profileImageLocator).isDisplayed(), "Image for invite friends popup wasn't shown");
        asert.assertAll();
    }

}
