package test;

import helper.Strings;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetUpCapabilities implements Strings {
//    private String PACKAGE_HOOPIT = "com.highlyrecommendedapps.droidkeeper";
//    private String MAIN_ACTIVITY = ".ui.MainActivity"

    public DesiredCapabilities capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "8.1");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", PACKAGE_HOOPIT);
        capabilities.setCapability("appWaitPackage", PACKAGE_HOOPIT);
        capabilities.setCapability("appActivity", MAIN_ACTIVITY);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
        return capabilities;
    }
}
