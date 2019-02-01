package helper;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolbarHelper {
    private By toolbarLocator = By.id("com.vivalasport.hoopit:id/toolbar");
    private By backButtonLocator = By.id("com.vivalasport.hoopit:id/back");
    private By profileImageLocator = By.id("com.vivalasport.hoopit:id/profile_image");
    private By userRangLocator = By.id("id/tv_level");
    private By userTitleLocator = By.id("id/tv_user_title");
    private By userPointsLocator = By.id("com.vivalasport.hoopit:id/tv_user_points");
    private By userPointsContainerLocator = By.id("com.vivalasport.hoopit:id/user_points_container");
    private By hotPlayerLocator = By.id("com.vivalasport.hoopit:id/hot_player");
    private By hotPlayerEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/hot_player_empty_indicator");
    private By doublePowerLocator = By.id("com.vivalasport.hoopit:id/double_power");
    private By doublePowerEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/double_power_empty_indicator");
    private By freeRunLocator = By.id("com.vivalasport.hoopit:id/free_run");
    private By freeRunEmptyIndicatorLocator = By.id("com.vivalasport.hoopit:id/free_run_empty_indicator");

    public int getUserCoins() {
        return Integer.parseInt($(userPointsLocator).getText());
    }

    public ToolbarHelper clickOnProfileIcon(){
        $(profileImageLocator).click();
        return this;
    }


}
