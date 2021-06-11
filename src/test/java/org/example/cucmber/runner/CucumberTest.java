package org.example.cucmber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",  "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"},glue = {"org.example.cucmber.stepdefinitions"},features = "classpath:features")
public class CucumberTest {
}
