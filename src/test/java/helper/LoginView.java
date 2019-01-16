package helper;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class LoginView extends BaseHelper {
    private By loginButtonsViewLocator = By.id("com.vivalasport.hoopit:id/social_login_buttons");
    private By locatorSignUpButton = By.id("com.vivalasport.hoopit:id/tv_sign_up_with_mail");
    private By locatorGoogleLoginButton = By.id("com.vivalasport.hoopit:id/google_login");
    private By locatorFacebookLoginButton = By.id("com.vivalasport.hoopit:id/facebook_login");
    private By locatorEmailSignUpButton = By.id("com.vivalasport.hoopit:id/email_sign_up");
    private By locatorScreenNameField = By.id("com.vivalasport.hoopit:id/screen_name");
    private By locatorEmailField = By.id("com.vivalasport.hoopit:id/et_email");
    private By locatorPasswordField = By.id("com.vivalasport.hoopit:id/et_password");
    private By locatorScreenNameErrorText = By.xpath("//android.widget.LinearLayout[@resource-id='com.vivalasport.hoopit:id/input_layout_screen_name']//android.widget.TextView[@resource-id='com.vivalasport.hoopit:id/textinput_error']");
    private By locatorEmailErrorText = By.xpath("//android.widget.LinearLayout[@resource-id='com.vivalasport.hoopit:id/input_layout_email']//android.widget.TextView[@resource-id='com.vivalasport.hoopit:id/textinput_error']");
    private By locatorPasswordErrorText = By.xpath("//android.widget.LinearLayout[@resource-id='com.vivalasport.hoopit:id/input_layout_password']//android.widget.TextView[@resource-id='com.vivalasport.hoopit:id/textinput_error']");

    public LoginView assertOpenedLoginView() {
        assertTrue($(loginButtonsViewLocator).isDisplayed(), "Login view wasn't shown");
        return this;
    }

    public void assertPresenceElementsOnSignUpView() {
        SoftAssert asert = new SoftAssert();
        asert.assertTrue($(locatorSignUpButton).isDisplayed() && $(locatorSignUpButton).isEnabled(), "");
        asert.assertTrue($(locatorGoogleLoginButton).isDisplayed() && $(locatorGoogleLoginButton).isEnabled(), "");
        asert.assertTrue($(locatorFacebookLoginButton).isDisplayed() && $(locatorFacebookLoginButton).isEnabled(), "");
        asert.assertAll();
    }

    public void loginAs(String user_name, String email, String password) {
        $(locatorSignUpButton).click();
        $(locatorScreenNameField).val(user_name);
        $(locatorEmailField).val(email);
        $(locatorPasswordField).val(password);
        $(locatorEmailSignUpButton).click();
    }

    public void assertErrorMessage(String user_name_error_message, String email_error_message, String password_error_message) {
        SoftAssert asert = new SoftAssert();
        if (user_name_error_message != null) {
            asert.assertEquals($(locatorScreenNameErrorText).getText(), user_name_error_message, "Incorrect error message for user name");
        }
        if (email_error_message != null) {
            asert.assertEquals($(locatorEmailErrorText).getText(), email_error_message, "Incorrect error message for email");
        }
        if (password_error_message != null) {
            asert.assertEquals($(locatorPasswordErrorText).getText(), password_error_message, "Incorrect error message for getPassword");
        }
        asert.assertAll();
    }

}
