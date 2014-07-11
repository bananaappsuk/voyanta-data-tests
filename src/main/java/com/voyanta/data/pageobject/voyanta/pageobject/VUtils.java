package com.voyanta.data.pageobject.voyanta.pageobject;

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
}
