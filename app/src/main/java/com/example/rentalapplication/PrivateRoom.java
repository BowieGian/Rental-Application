package com.example.rentalapplication;

import java.io.Serializable;
import java.util.Calendar;

public class PrivateRoom extends Rental implements Serializable {
    private int numGuests;
    private int numBeds;
    private int numBaths;

    public PrivateRoom() {

    }

    public PrivateRoom(int inYear, int inMonth, int inDay,
                       int outYear, int outMonth, int outDay,
                     int numGuests, int numBeds, int numBaths,
                     boolean petFriendly, boolean smokeFree, String location,
                     double rating, double price, String imageUrl) {
        super(inYear, inMonth, inDay, outYear, outMonth, outDay,
                petFriendly, smokeFree, location, rating, price, imageUrl);
        this.numGuests = numGuests;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
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

    public boolean setNumBathrooms(int numBathrooms) {
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
