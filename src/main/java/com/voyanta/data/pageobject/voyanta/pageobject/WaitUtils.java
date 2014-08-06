package com.voyanta.data.pageobject.voyanta.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

/**
 * Created by sriramangajala on 22/07/2014.
 */
public class WaitUtils {
    static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(WaitUtils.class);
    public static void waitForElementShown(WebDriver driver, By by) {

        LOGGER.info("Started waiting for the Element Visible happen...");
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LOGGER.info("Waiting over...");

    }

    public static void waitForTextIsNotPresentInElement(WebDriver driver, By by, String text) {
        LOGGER.info("Started waiting for the text to be shown...");
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        int i=0;
        while(driver.findElement(by).getText().contains(text)&&i<30)
        {
            VUtils.waitFor(1);
            i++;
            LOGGER.info("Waiting for 1 sec... for text to be gone: "+text);
        }
//        webDriverWait.until(ExpectedConditions.(driver.findElement(by),text));
        LOGGER.info("Waiting over...");
    }
}
