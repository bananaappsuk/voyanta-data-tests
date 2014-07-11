package com.voyanta.data.regression;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"})
public class SmokeTest {
}





