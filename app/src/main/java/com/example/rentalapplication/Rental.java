package com.example.rentalapplication;

public class Rental {
    private int sellerID;
    private String address;
    private String location;
    private String availability;
    private boolean petFriendly;
    private boolean smoke;
    private boolean parking;
    private double price;
    private double rating;
    private String hostContact;
    private boolean wifi;
    // photos?

    public Rental() {

    }

    // set everything but price and rating
    public Rental(String address, String location, String availability, boolean petFriendly, boolean smoke, boolean parking, String hostContact, boolean wifi) {
        this.address = address;
        this.location = location;
        this.availability = availability;
        this.petFriendly = petFriendly;
        this.smoke = smoke;
        this.parking = parking;
        this.hostContact = hostContact;
        this.wifi = wifi;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
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

    public String getHostContact() {
        return hostContact;
    }

    public void setHostContact(String hostContact) {
        this.hostContact = hostContact;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
