package helper.tabs;

import helper.BaseHelper;
import org.openqa.selenium.By;

public class DrawerHelper extends BaseHelper {

    private By userNameLocator = By.id("com.vivalasport.hoopit:id/drawer_user_name");
    private By hotPlayerLocator = By.id("com.vivalasport.hoopit:id/hot_player");
    private By hotPlayerEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/hot_player_empty_indicator");
    private By doublePowerLocator = By.id("com.vivalasport.hoopit:id/double_power");
    private By doublePowerEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/double_power_empty_indicator");
    private By freeRunLocator = By.id("com.vivalasport.hoopit:id/free_run");
    private By freeRunEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/free_run_empty_indicator");
    private By myProfileLocator = By.id("com.vivalasport.hoopit:id/your_details");
    private By completeProfileLocator = By.id("com.vivalasport.hoopit:id/complete_profile");
}
