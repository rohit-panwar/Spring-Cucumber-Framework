package com.qa.automation.runner;

import com.qa.automation.helpers.BaseSetup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(features = "src/test/resources/features",
        extraGlue = "com.qa.automation.stepdefs",
        plugin = {"pretty","html:target/reports/CucumberHTMLReport.html"},
        tags = "@First"
)
public class TestRunner {

    @BeforeClass
    public static void beforeClass(){
        try {
            BaseSetup.setProfilePath();
            BaseSetup.getInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterClass(){
        try {
            BaseSetup.killDriverInstance();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
