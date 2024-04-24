package com.assignment;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.PlayStoreApp.PlayStoreApp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AndroidDriver<MobileElement> driver;
    public PlayStoreApp playStoreApp;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        // desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Q8BITOGAONIFC6S8");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.vending");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.vending.AssetBrowserActivity");
        desiredCapabilities.setCapability("appium:session-override", true);
       // desiredCapabilities.setCapability("skipDeviceInitialization", true);
      //  desiredCapabilities.setCapability("noReset", true);



        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        playStoreApp = new PlayStoreApp(driver);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
