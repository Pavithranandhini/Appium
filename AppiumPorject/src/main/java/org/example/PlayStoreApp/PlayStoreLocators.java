package org.example.PlayStoreApp;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PlayStoreLocators {

    static final String GAMES_TAB_SELECTOR = "new UiSelector().className('android.widget.ImageView').instance(3)";
    static final String APPS_TAB_SELECTOR = "new UiSelector().className('android.widget.ImageView').instance(2)";
    By CategoriesTab = By.xpath("//android.widget.TextView[@text='Categories']");

    By SearchText = By.xpath("//android.widget.TextView[@text='Search Apps & Games']");
    By NavigateBack = By.xpath("//android.view.View[@content-desc='Navigate up']");

    By gamesTab = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[6]/android.view.View/android.view.View[1]/ghe/android.widget.ImageView");

    By TravelAndLocal = By.xpath("//android.widget.TextView[@content-desc=\"travel & local\"]");
    By AppsTab = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[6]/android.view.View/android.view.View[2]/ghe/android.widget.ImageView");
 By IndigoFlight = By.xpath("(//android.widget.ImageView[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"])[5]");

 By TravelAndLocalText = By.xpath("//android.widget.FrameLayout[@content-desc=\"Travel & local\n" +
         "\"]");

}