package org.example;

import io.appium.java_client.*;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public By setValueForLocatorAndPath(String element, String value) {
        By by = null;
        if (element.equalsIgnoreCase("xpath")) {
            by = By.xpath(value);
        } else if (element.equalsIgnoreCase("className")) {
            by = By.className(value);
        } else if (element.equalsIgnoreCase("id")) {
            by = By.id(value);
        } else if (element.equalsIgnoreCase("name")) {
            by = By.name(value);
        } else if (element.equalsIgnoreCase("css")) {
            by = By.cssSelector(value);
        } else if ((element.equalsIgnoreCase("partialLinkText"))) {
            by = By.partialLinkText(value);
        } else if (element.equalsIgnoreCase("linkText")) {
            by = By.linkText(value);
        } else if (element.equalsIgnoreCase("tag")) {
            by = By.tagName(value);
        }
        return by;
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Change timeout as needed
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementSelected(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Change timeout as needed
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementPresent(AndroidDriver<MobileElement> driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void swipeLeft(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int startY = size.height / 2;
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    public static void swipeDown(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.7);
        int endX = (int) (size.height * 0.3);
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

    public void flingVerticalToBottom_Android(WebElement element) {
        try {
            driver.findElements(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).setAsVerticalList().flingToEnd(2)"));
        } catch (Exception e) {
            // ignore
        }
        element.click();
    }

    public static void scrollToElement(MobileDriver driver, WebElement element, long duration) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        boolean elementFound = false;

        while (!elementFound) {
            TouchAction<?> action = new TouchAction<>(driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
            if (element.isDisplayed()) {
                elementFound = true;
            }
        }
    }
    }

