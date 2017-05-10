package com.example.aqsashaaparr.validatorepay;

/**
 * Created by AQSA SHaaPARR on 5/9/2017.
 */

public class FareData {

    String Fare_ID;
    String Fare_route;
    String Fare_price;
    String Fare_type;
    String added_by;
    String update_by;
    String date_added;
    String date_updated;

    public FareData(String fare_ID, String fare_route, String fare_price, String fare_type, String added_by, String update_by, String date_added, String date_updated) {
        Fare_ID = fare_ID;
        Fare_route = fare_route;
        Fare_price = fare_price;
        Fare_type = fare_type;
        this.added_by = added_by;
        this.update_by = update_by;
        this.date_added = date_added;
        this.date_updated = date_updated;
    }

    public FareData(){

    }




    public String getFare_ID() {
        return Fare_ID;
    }

    public void setFare_ID(String fare_ID) {
        Fare_ID = fare_ID;
    }

    public String getFare_route() {
        return Fare_route;
    }

    public void setFare_route(String fare_route) {
        Fare_route = fare_route;
    }

    public String getFare_price() {
        return Fare_price;
    }

    public void setFare_price(String fare_price) {
        Fare_price = fare_price;
    }

    public String getFare_type() {
        return Fare_type;
    }

    public void setFare_type(String fare_type) {
        Fare_type = fare_type;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }



}
