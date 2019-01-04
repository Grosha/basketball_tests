package test;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SetUpCapabilities {
//    private String packageDK = "com.highlyrecommendedapps.droidkeeper";
//    private String mainActivity = ".ui.MainActivity";
    private static String mainActivity = "com.athena.app.ui.splash.SplashActivity";
    private static String packageDK = "com.vivalasport.hoopit";


    public DesiredCapabilities capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "8.1");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", packageDK);
        capabilities.setCapability("appWaitPackage", packageDK);
        capabilities.setCapability("appActivity", mainActivity);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
        return capabilities;
    }
}
