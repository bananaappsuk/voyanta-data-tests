package com.voyanta.data.pageobject.voyanta;

/**
 * Created by sriramangajala on 04/07/2014.
 */

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SimpleOnFailed extends TestWatcher {
        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Only executed when a test fails");

                TakesScreenshot takesScreenshot = (TakesScreenshot) abstractBaseTest.driver;

                File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                File destFile = getDestinationFile(description);
                try {
                    FileUtils.copyFile(scrFile, destFile);
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }

            System.out.println("Screen shot taken :"+destFile.getName());
        }

    private File getDestinationFile(Description description) {
        String userDirectory = "target/surefire-reports";//FileUtils.getUserDirectoryPath();
        String fileName = description+"_screenShot.png";
        String absoluteFileName = userDirectory + "/" + fileName;
        System.out.println(absoluteFileName);
        return new File(absoluteFileName);
    }
    }

