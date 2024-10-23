package com.qa.automation.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.automation.SpringBootCucumberApplication;
import com.qa.automation.helpers.CommonObject;
import com.qa.automation.helpers.SeleniumWebDriver;
import com.qa.automation.steplibs.StepLibs;
import com.qa.automation.utils.Generics;
import com.qa.automation.utils.RestUtils;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {SpringBootCucumberApplication.class})
public class StepDefinations {

    @Autowired
    private SeleniumWebDriver seleniumWebDriver;
    @Autowired
    public CommonObject baseObject;
    @Autowired
    public StepLibs stepLibs;
    @Autowired
    RestUtils restUtils;
    @Autowired
    Generics generics;


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

    @Given("I set the request payload to fetch bookings")
    public void iSetTheRequestPayloadToFetchBookings() {
        System.out.println("<<<<<<< SETUP >>>>>");
    }

    @When("I send request to fetch the booking details")
    public void iSendRequestToFetchTheBookingDetails() {
        stepLibs.fetchAllBookingDetails();
    }

    @Then("I validate the response")
    public void iValidateTheResponse() {
    }

    Scenario scenario;
    @Before
    public void test(Scenario scenario){
        this.scenario=scenario;
    }

    @Given("I set the request payload to create bookings")
    public void iSetTheRequestPayloadToCreateBookings() throws Throwable {
        baseObject.bookingDetailPayload= stepLibs.setBookingDetails();
        System.out.println(baseObject.bookingDetailPayload);

        baseObject.scenario.log("Log"+baseObject.bookingDetailPayload);
    }

    @When("I send request to create a new booking")
    public void iSendRequestToCreateANewBooking() {
        String basePath="https://restful-booker.herokuapp.com";
        String queryPath="/booking";

        String url= basePath+queryPath;
        System.out.println("Request URL: "+url);

        Response response = restUtils.request()
                        .contentType("application/json")
                                .body(baseObject.bookingDetailPayload)
                                        .post(url);

        Assert.assertEquals("Status", 200, response.getStatusCode());
        System.out.println(generics.getJsonNodeObject(response.asString()));

        //baseObject.allBookingsResponse=generics.getJsonNodeObject(response.asString());
        //System.out.println(baseObject.allBookingsResponse);
    }
}