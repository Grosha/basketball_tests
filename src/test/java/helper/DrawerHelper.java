package helper;

import helper.BaseHelper;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DrawerHelper extends BaseHelper {

    private By userNameLocator = By.id("com.vivalasport.hoopit:id/drawer_user_name");

    private By myProfileLocator = By.id("com.vivalasport.hoopit:id/your_details");
    private By completeProfileLocator = By.id("com.vivalasport.hoopit:id/complete_profile");

    public DrawerHelper openProfile() {
        $(myProfileLocator).click();
        return this;
    }
}
