package com.voyanta.data;

import com.voyanta.data.utils.SystemLibrary;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@Cucumber.Options(tags="@ram_new",format = {"pretty", "html:target/cucumber","json:target/cucumber.json"})
public class VoyantaCucumberTest {
}





