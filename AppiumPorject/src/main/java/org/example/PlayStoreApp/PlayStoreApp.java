package org.example.PlayStoreApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;


public class PlayStoreApp extends BasePage implements PlayStoreLocators {
    AndroidDriver<MobileElement> androidDriver;
    private Object previousScrollPosition = null;
    public PlayStoreApp(AppiumDriver driver) {
        super(driver);
    }

    public void swipeTillCategoriesTab(AndroidDriver<MobileElement> driver) {
        // Let's swipe until the Categories tab is visible
        while (!isElementPresent(driver, PlayStoreLocators.CategoriesTab)) {
            swipeLeft(driver);
        }
    }

    public void clickOnCategoriesTab() {

        WebElement element = driver.findElement(PlayStoreLocators.CategoriesTab);
        element.click();
    }

    public void searchText() {
        WebElement search_bar = driver.findElement(PlayStoreLocators.SearchText);
        search_bar.click();
        WebElement navigate_back = driver.findElement(PlayStoreLocators.NavigateBack);
        navigate_back.click();
    }

    public void verifyGamesSectionSelected(AndroidDriver<MobileElement> driver) {
        // Verify "Games" section is selected by Default in bottom navigation
        WebElement gamesTab = driver.findElement(PlayStoreLocators.gamesTab);
        if (!gamesTab.getAttribute("selected").equals("true")) {
            // If "Games" section is not selected, then click the "Games" tab
            gamesTab.click();
            System.out.println("Selected tab: Games");
        }
        assert gamesTab.getAttribute("selected").equals("true") : "Games section is not selected by default in bottom navigation.";
        System.out.println("Games section is selected by default in bottom navigation.");
    }

    public void verifyTravelAndLocalNotDisplayed(AndroidDriver<MobileElement> driver) {
        // Verify "Travel & Local" is not displayed in the games section

        boolean isTravelAndLocalDisplayed = isElementPresent(driver, PlayStoreLocators.TravelAndLocal);
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"));

        assert !isTravelAndLocalDisplayed : "Travel & Local category is displayed under the Games section.";
        System.out.println("Travel & Local category is not displayed under the Games section.");
    }

    public void verifyAppsSectionSelected(AndroidDriver<MobileElement> driver) {
        // Verify "Games" section is selected by Default in bottom navigation
        WebElement appsTab = driver.findElement(PlayStoreLocators.AppsTab);
        if (!appsTab.getAttribute("selected").equals("true")) {
            // If "Games" section is not selected, then click the "Games" tab
            appsTab.click();
            System.out.println("Selected tab: Games");
        }
        assert appsTab.getAttribute("selected").equals("true") : "Games section is not selected by default in bottom navigation.";
        System.out.println("app section is selected in bottom navigation.");
    }


public void SelectTravelAndLocalText(){
       String text = "Travel & Local";
        scrollToElement(text);
}
    public void verifyIndigoFlightIsDisplaying() {
        WebElement text = driver.findElement(PlayStoreLocators.TravelAndLocalText);
        text.click();


    }



    public void scrollToElement(String elementText) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
       // Adjust the timeout as needed
        while (true) {
            try {

                // Try to find the element on the current page
              WebElement travelText =  driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                                + ".scrollIntoView(new UiSelector().textMatches(\"" + elementText + "\").instance(0))"));
              travelText.click();
                // Element found, break the loop
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                // Scroll forward to the next page
                driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                                + ".scrollForward()"));
                // Wait for the element to be present on the new page
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + elementText + "\")")));
            }
        }
    }
}
