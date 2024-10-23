package com.qa.automation.steplibs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.automation.helpers.CommonObject;
import com.qa.automation.models.applicationCreation.Bookingdates;
import com.qa.automation.models.applicationCreation.CreateBooking;
import com.qa.automation.utils.Generics;
import com.qa.automation.utils.RestUtils;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@ScenarioScope
public class StepLibs {

    @Autowired
    CommonObject baseObject;

    @Autowired
    RestUtils restUtils;

    @Autowired
    Generics generics;

    //String url;
    public void fetchAllBookingDetails(){

        String basePath="https://restful-booker.herokuapp.com";
        String queryPath="/booking";

        String url= basePath+queryPath;
        System.out.println("Request URL: "+url);

        Response response = restUtils.request().get(url);

        Assert.assertEquals("Status", 200, response.getStatusCode());
        baseObject.allBookingsResponse=generics.getJsonNodeObject(response.asString());
        System.out.println(baseObject.allBookingsResponse);
    }

    public String setBookingDetails() throws Throwable {
        CreateBooking createBooking= new CreateBooking();
        createBooking.setFirstname("Rohit");
        createBooking.setLastname("Panwar");
        createBooking.setTotalprice(5000);
        createBooking.setDepositpaid(true);
        Bookingdates bookingdates= new Bookingdates();
        String checkIn="2024-01-01";
        bookingdates.setCheckin("2024-01-01");
        bookingdates.setCheckout("2024-02-02");
        createBooking.setBookingdates(bookingdates);
        createBooking.setAdditionalneeds("Breakfast");

        return generics.getMapper().writeValueAsString(createBooking);
    }
}
