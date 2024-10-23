package com.qa.automation.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.Scenario;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
@ScenarioScope
public class CommonObject {

    public WebDriver driver;
    public Scenario scenario;
    public JsonNode allBookingsResponse;
    public String bookingDetailPayload;
}
