package helper.tabs.home;

import org.openqa.selenium.By;

public class HomeTabHelper {
    private By homeTabLocator = By.id("com.vivalasport.hoopit:id/nav_home");

    public By getHomeTab() {
        return homeTabLocator;
    }
}
