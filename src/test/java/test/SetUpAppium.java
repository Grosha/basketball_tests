package test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class SetUpAppium {
//    private String packageDK = "com.highlyrecommendedapps.droidkeeper";
//    private String mainActivity = ".ui.MainActivity";
    private String mainActivity = "com.athena.app.ui.splash.SplashActivity";
    private String packageDK = "com.vivalasport.hoopit";
    public AndroidDriver driver;
    public DesiredCapabilities capabilities = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "8.1");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", packageDK);
        capabilities.setCapability("appWaitPackage", packageDK);
        capabilities.setCapability("appActivity", mainActivity);
//        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        initDriver();
    }

    @After
    public void setDown() {
        driver.quit();
    }

    public void initDriver(AndroidDriver driver ) {

    }

    public void waitForElement(WebElement element, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
    }
}
