package com.example.rentalapplication.data;

import java.io.Serializable;

public class Rental implements Serializable {
    private String key;
    private String inDate;
    private String outDate;

    private boolean petFriendly;
    private boolean smokeFree;
    private String location;
    private double rating;
    private double price;

    private String imageUrl;

    public Rental() {

    }

    public Rental(String inDate, String outDate,
                  boolean petFriendly, boolean smokeFree, String location,
                  double rating, double price, String imageUrl) {
        this.inDate = inDate;
        this.outDate = outDate;
        this.petFriendly = petFriendly;
        this.smokeFree = smokeFree;
        this.location = location;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
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
