package com.example.rentalapplication;

public class Rental {
    private String inDate;
    private String outDate;

    private boolean petFriendly;
    private boolean smokeFree;
    private double rating;
    private double price;
    private String address;
    private String location;

    private int sellerID;
    private String photoLink;

    public Rental() {

    }

    // set everything but price and rating


    public Rental(String inDate, String outDate,
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
