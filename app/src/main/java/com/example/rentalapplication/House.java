package com.example.rentalapplication;

import java.io.Serializable;
import java.util.Calendar;

public class House extends Rental implements Serializable {
    private int numGuests;
    private int numRooms;
    private int numBeds;
    private int numBaths;

    public House() {

    }

    public House(String inDate, String outDate,
                     int numGuests, int numRooms, int numBeds, int numBaths,
                     boolean petFriendly, boolean smokeFree, String location,
                     double rating, double price, String imageUrl) {
        super(inDate, outDate,
                petFriendly, smokeFree, location, rating, price, imageUrl);
        this.numGuests = numGuests;
        this.numRooms = numRooms;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean setNumRooms(int numRooms) {
        if (numRooms < 1)
            return false;
        this.numRooms = numRooms;
        return true;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public boolean setNumGuests(int numGuests) {
        if (numGuests < 1)
            return false;
        this.numGuests = numGuests;
        return true;
    }

    public int getNumBaths() {
        return numBaths;
    }

    public boolean setNumBaths(int numBathrooms) {
        if (numBathrooms < 1)
            return false;
        this.numBaths = numBathrooms;
        return true;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public boolean setNumBeds(int numBeds) {
        if (numBeds < 1)
            return false;
        this.numBeds = numBeds;
        return true;
    }
}
