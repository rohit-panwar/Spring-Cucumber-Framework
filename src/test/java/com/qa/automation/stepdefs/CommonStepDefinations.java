package com.qa.automation.stepdefs;

import com.qa.automation.helpers.BaseSetup;
import com.qa.automation.helpers.CommonObject;
import com.qa.automation.helpers.SeleniumWebDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static com.qa.automation.helpers.BaseSetup.properties;

public class CommonStepDefinations {

    @Autowired
    SeleniumWebDriver seleniumWebDriver;

    @Autowired
    CommonObject baseObject;

    @Given("I create a webdriver instance")
    public void i_create_a_webdriver_instance() {
        baseObject.driver=seleniumWebDriver.getDriver();
        baseObject.driver.manage().window().maximize();
    }

    @Given("I navigate to login page")
    public void i_navigate_to_login_page() {
        //baseObject.driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("URL :: will launch");
        System.out.println("URL :: "+properties.getProp("WebURL"));
        baseObject.driver.get(properties.getProp("WebURL"));
    }

    @When("I complete the login process")
    public void i_complete_the_login_process() {
        baseObject.driver.findElement(By.id("username")).sendKeys("student");
        baseObject.driver.findElement(By.id("password")).sendKeys("Password123");
        baseObject.driver.findElement(By.id("submit")).click();
    }

    @Then("I should navigate to home page")
    public void i_should_navigate_to_home_page() {
        Assert.assertEquals("Logged In Successfully | Practice Test Automation",baseObject.driver.getTitle());
    }

    @Then("I quit webdriver instance")
    public void i_quit_webdriver_instance() {
        baseObject.driver.quit();
    }
}
