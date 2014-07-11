package com.voyanta.data.utils.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementIsDisplayed implements Condition {
    @Override
    public boolean isSatisfied() {
        return false;
    }

    @Override
    public String describe() {
        return null;
    }

//    private static final Logger LOGGER = Logger.getLogger(com.venkyold.org.adv.utils.ElementIsDisplayed.class);
//    private By by;
//    private WebElement element;
//    private String elementDescription = null;
//
//    public ElementIsDisplayed(By by) {
//        this.by = by;
//    }
//
//    public ElementIsDisplayed(By by, String elementDescription) {
//        this.elementDescription = elementDescription;
//        this.by = by;
//    }
//
//    public ElementIsDisplayed(WebElement element) {
//        this.element = element;
//    }
//
//
//    public ElementIsDisplayed(WebElement element, String elementDescription) {
//        this.element = element;
//        this.elementDescription = elementDescription;
//    }
//
//    public boolean isSatisfied() {
//        try {
//            if (by != null) {
//                element = CoreDriver.findElement(by, 0);
//            }
//            return element.isDisplayed();
//        } catch (Exception e) {
//            if (!e.getClass().equals(NoSuchElementException.class));// LOGGER.info(e.getClass().getSimpleName() + " thrown while waiting for condition [" + describe() + "]", true);
//            return false;
//        }
//
//    }
//
//    public String describe() {
//        return "Waiting for an element to be displayed" + (elementDescription == null ? StringUtils.EMPTY : " [" + elementDescription + "]");
//    }

}
