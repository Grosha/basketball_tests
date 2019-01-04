package helper;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ToolbarHelper {
    private By toolbarLocator = By.id("com.vivalasport.hoopit:id/toolbar");
    private By backButtonLocator = By.id("com.vivalasport.hoopit:id/back");
    private By profileImageLocator = By.id("id/profile_image");
    private By userRangLocator = By.id("id/tv_level");
    private By userTitleLocator = By.id("id/tv_user_title");
    private By userPointsLocator = By.id("com.vivalasport.hoopit:id/tv_user_points");
    private By userPointsContainerLocator = By.id("com.vivalasport.hoopit:id/user_points_container");
}
