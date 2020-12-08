package com.example.rentalapplication;

import java.io.Serializable;
import java.util.Calendar;

public class Rental implements Serializable {
    private int inYear;
    private int inMonth;
    private int inDay;
    private int outYear;
    private int outMonth;
    private int outDay;

    private boolean petFriendly;
    private boolean smokeFree;
    private String location;
    private double rating;
    private double price;

    private int sellerID;
    private String imageUrl;

    public Rental() {

    }

    public Rental(int inYear, int inMonth, int inDay,
                  int outYear, int outMonth, int outDay,
                  boolean petFriendly, boolean smokeFree, String location,
                  double rating, double price, String imageUrl) {
        this.inYear = inYear;
        this.inMonth = inMonth;
        this.inDay = inDay;
        this.outYear = outYear;
        this.outMonth = outMonth;
        this.outDay = outDay;
        this.petFriendly = petFriendly;
        this.smokeFree = smokeFree;
        this.location = location;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getInYear() {
        return inYear;
    }

    public void setInYear(int inYear) {
        this.inYear = inYear;
    }

    public int getInMonth() {
        return inMonth;
    }

    public void setInMonth(int inMonth) {
        this.inMonth = inMonth;
    }

    public int getInDay() {
        return inDay;
    }

    public void setInDay(int inDay) {
        this.inDay = inDay;
    }

    public int getOutYear() {
        return outYear;
    }

    public void setOutYear(int outYear) {
        this.outYear = outYear;
    }

    public int getOutMonth() {
        return outMonth;
    }

    public void setOutMonth(int outMonth) {
        this.outMonth = outMonth;
    }

    public int getOutDay() {
        return outDay;
    }

    public void setOutDay(int outDay) {
        this.outDay = outDay;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public boolean isSmokeFree() {
        return smokeFree;
    }

    public void setSmokeFree(boolean smokeFree) {
        this.smokeFree = smokeFree;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price < 0)
            return false;
        this.price = price;
        return true;
    }

    public double getRating() {
        return rating;
    }

    public boolean setRating(double rating) {
        if (rating < 0 || rating > 5)
            return false;
        this.rating = rating;
        return true;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
