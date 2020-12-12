package com.example.rentalapplication.data;

import java.io.Serializable;

public class PrivateRoom extends Rental implements Serializable {
    private int numBeds;
    private int numBaths;

    public PrivateRoom() {

    }

    public PrivateRoom(String inDate, String outDate,
                       int numBeds, int numBaths,
                       boolean petFriendly, boolean smokeFree, String location,
                       double rating, double price, String imageUrl) {
        super(inDate, outDate,
                petFriendly, smokeFree, location, rating, price, imageUrl);
        this.numBeds = numBeds;
        this.numBaths = numBaths;
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
