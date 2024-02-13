package com.qa.automation.stepdefs;

import com.qa.automation.SpringBootCucumberApplication;
import com.qa.automation.helpers.CommonObject;
import com.qa.automation.helpers.SeleniumWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {SpringBootCucumberApplication.class})
public class StepDefinations {

    @Autowired
    SeleniumWebDriver seleniumWebDriver;

    @Autowired
    CommonObject baseObject;

    @Given("User is ready with test data")
    public void user_is_ready_with_test_data() {
        System.out.println("************* Given *******************");
        seleniumWebDriver.printMessage();
    }

    @When("User launch the browser")
    public void user_launch_the_browser() {
        System.out.println("************* When *******************");
        baseObject.driver = seleniumWebDriver.getDriver();
        baseObject.driver.get("https://www.google.com/");
    }

    @Then("Chrome browser opened")
    public void chrome_browser_opened() {
        System.out.println("************* Then *******************");
        baseObject.driver.quit();
    }
}