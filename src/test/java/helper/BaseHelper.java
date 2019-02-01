package helper;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.aspectj.weaver.loadtime.Agent.getInstrumentation;

public class BaseHelper {
    private String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    private String emailCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private By progressBarImage = By.id("com.vivalasport.hoopit:id/gifImageView");

    public String getNewEmail() {
        String email = RandomStringUtils.random( 10, emailCharacters).concat("@aloha.com");
        return email;
    }

    public String getPassword() {
        return RandomStringUtils.random( 10, passwordCharacters);
    }

    public void waiter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
