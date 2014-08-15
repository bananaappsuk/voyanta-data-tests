package com.voyanta.data;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sriramangajala on 14/07/2014.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(tags={"@export","~@ignore"},format = {"pretty", "html:target/cucumber","json:target/cucumber.json"})
public class ExportRunFile {
}
