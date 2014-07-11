package com.voyanta.data.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sriramangajala on 08/07/2014.
 */
public class PropertiesLoader {

    public static Properties getProperties() {
        return prop;
    }

    public static void setProp(Properties prop) {
        PropertiesLoader.prop = prop;
    }

    static Properties prop;
    static String strDataSheetLocation = "src/main/resources/framework.properties";

    public static String getProperty(String key)
    {
        if(getProperties()==null)
        {
            loadPropertyFile();
        }

        return prop.getProperty(key);
    }

    private static void loadPropertyFile() {
        prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream(strDataSheetLocation);
            System.out.println(input);
            prop.load(input);
            System.out.print(prop.getProperty("TEST_FILE_NAME"));
//            , "firefox"));
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
