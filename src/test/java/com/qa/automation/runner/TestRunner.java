package com.qa.automation.runner;

import com.qa.automation.helpers.BaseSetup;
import com.qa.automation.utils.CucumberReport;
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
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumber-json-report.json",},
        tags = "@POST"
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
            CucumberReport.generateCucumberReport();
            BaseSetup.killDriverInstance();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
