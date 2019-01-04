package helper;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class LoginView {
    private By loginButtonsViewLocator = By.id("com.vivalasport.hoopit:id/social_login_buttons");

    public LoginView assertOpenedLoginView() {
        assertTrue($(loginButtonsViewLocator).isDisplayed(), "Login view wasn't shown");
        return this;
    }
}
