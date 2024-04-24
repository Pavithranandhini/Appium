package com.assignment.PlayStoreTest;

import com.assignment.BaseTest;


import org.example.PlayStoreApp.PlayStoreApp;
import org.example.PlayStoreApp.PlayStoreLocators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PlayStoreTest extends BaseTest {
    @Test(priority = 1)
    public void launchPlayStoreApp() throws InterruptedException {
        // Wait for the Play Store app to be launched
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void clickOnCategoryTab() throws InterruptedException {
        playStoreApp.searchText();
        playStoreApp.swipeTillCategoriesTab(driver);
        playStoreApp.clickOnCategoriesTab();
    }

    @Test(priority = 3)
    public void clickOnGamesTab(){
        playStoreApp.verifyGamesSectionSelected(driver);
    }
    @Test(priority = 4)
    public void verifyTravelAndLocalNotDisplayed() {
        playStoreApp.verifyTravelAndLocalNotDisplayed(driver);
    }
    @Test(priority=5)
    public void verifyTravelAndLocalDisplayed() throws InterruptedException {
        playStoreApp.verifyAppsSectionSelected(driver);
       playStoreApp.SelectTravelAndLocalText();

    }
    @Test(priority = 6)
            public void verifyIndigoFlightIsDsiplaying(){
        playStoreApp.verifyIndigoFlightIsDisplaying();
        WebElement indigoFlightApp = driver.findElement(PlayStoreApp.IndigoFlight);
        boolean isIndigoFlightDisplayed = indigoFlightApp.isDisplayed();
        Assert.assertTrue(isIndigoFlightDisplayed);
    }


}

