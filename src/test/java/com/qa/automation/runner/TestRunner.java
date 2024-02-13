package com.qa.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(features = "src/test/resources/features",
        extraGlue = "com.qa.automation.stepdefs",
        plugin = {"pretty","html:target/reports/CucumberHTMLReport.html"},
        tags = "@Login"
)
public class TestRunner {
}
