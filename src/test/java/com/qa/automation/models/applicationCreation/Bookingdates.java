package com.qa.automation.models.applicationCreation;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

   
public class Bookingdates {

   @SerializedName("checkin")
   String checkin;

   @SerializedName("checkout")
   String checkout;


    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckin() {
        return checkin;
    }
    
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public String getCheckout() {
        return checkout;
    }
    
}