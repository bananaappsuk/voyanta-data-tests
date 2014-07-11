package com.voyanta.data.pageobject.voyanta;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(tags="@Search",format = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"})
public class SearchTest {
}





