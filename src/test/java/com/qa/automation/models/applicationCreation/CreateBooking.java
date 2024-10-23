package com.qa.automation.models.applicationCreation;

import com.google.gson.annotations.SerializedName;


public class CreateBooking {

   @SerializedName("firstname")
   String firstname;

   @SerializedName("lastname")
   String lastname;

   @SerializedName("totalprice")
   int totalprice;

   @SerializedName("depositpaid")
   boolean depositpaid;

   @SerializedName("bookingdates")
   Bookingdates bookingdates;

   @SerializedName("additionalneeds")
   String additionalneeds;


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }
    
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public int getTotalprice() {
        return totalprice;
    }
    
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public boolean getDepositpaid() {
        return depositpaid;
    }
    
    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }
    public Bookingdates getBookingdates() {
        return bookingdates;
    }
    
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    
}