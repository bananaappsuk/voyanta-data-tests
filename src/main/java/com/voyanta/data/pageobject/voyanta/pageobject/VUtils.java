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
}
