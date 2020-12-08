package com.example.rentalapplication;

import java.io.Serializable;
import java.util.Calendar;

public class Rental implements Serializable {
    private Calendar inDate;
    private Calendar outDate;

    private boolean petFriendly;
    private boolean smokeFree;
    private double rating;
    private double price;
    private String location;

    private int sellerID;
    private String imageUrl;

    public Rental() {

    }

    // set everything but price and rating


    public Rental(Calendar inDate, Calendar outDate,
                  boolean petFriendly, boolean smokeFree, String location) {
        this.inDate = inDate;
        this.outDate = outDate;
        this.petFriendly = petFriendly;
        this.smokeFree = smokeFree;
        this.location = location;
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

    public Calendar getInDate() {
        return inDate;
    }

    public void setInDate(Calendar inDate) {
        this.inDate = inDate;
    }

    public Calendar getOutDate() {
        return outDate;
    }

    public void setOutDate(Calendar outDate) {
        this.outDate = outDate;
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
