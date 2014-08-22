package com.voyanta.data.pageobject.voyanta.pageobject;


import com.voyanta.data.voyanta.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by sriramangajala on 11/07/2014.
 */
public class VUtils {
    public static void waitFor(int i) {
        try {
            Thread.sleep(i*1000);

        }
        catch (InterruptedException e)
        {

        }
    }

    public static String[] humaniseKeys(String keys) {
        String[] modifiedKeys = keys.trim().split(",");
      //  String[] modifiedKeys= new String[keys.split()];
        int i=0;
        for(String key:modifiedKeys)
        {
            modifiedKeys[i]=key.replace(" ","").trim().toLowerCase();
            i++;
        }
        if(modifiedKeys.length==0)
            return new String[]{""};
        else
            return modifiedKeys;
    }

    public static void captureScreen(String message) {
        try {
            WebDriver augmentedDriver = new Augmenter().augment(BrowserFactory.getDriver());
            File fileName;
            File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            fileName = new File("./target/screenshots/"  + message + ".png");
            if(fileName.exists())
            {
                fileName.delete();
            }
            FileUtils.copyFile(source, fileName);
        } catch (IOException e) {
            throw  new  RuntimeException("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
