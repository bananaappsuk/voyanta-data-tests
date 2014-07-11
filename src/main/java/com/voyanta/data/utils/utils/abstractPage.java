package com.voyanta.data.utils.utils;

import com.thoughtworks.selenium.Selenium;


public class abstractPage {

    public static Selenium sel;
    public CommonUtil util = new CommonUtil();

    public abstractPage()
    {
            sel=  CommonUtil.getSelenium();
    }


}
