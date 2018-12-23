package helper;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ToolbarHelper {
    private AndroidDriver driver;

    public ToolbarHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    private By backButtonLocator = By.id("id/back");
    private By profileImageLocator = By.id("id/profile_image");
    private By userRangLocator = By.id("id/tv_level");
    private By userTitleLocator = By.id("id/tv_user_title");
    private By userPointsLocator = By.id("id/tv_user_points");

}
