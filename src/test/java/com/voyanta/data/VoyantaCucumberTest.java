package com.voyanta.data;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@Cucumber.Options(tags="@ram",format = {"pretty", "html:target/cucumber-html-reports","json:target/cucumber-report.json"})
public class VoyantaCucumberTest {
}





