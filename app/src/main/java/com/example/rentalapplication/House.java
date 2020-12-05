package com.example.rentalapplication;

public class House extends Rental {
    private int numRooms;
    private int numGuests;
    private int numBathrooms;
    private int numBeds;

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

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public boolean setNumBathrooms(int numBathrooms) {
        if (numBathrooms < 1)
            return false;
        this.numBathrooms = numBathrooms;
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
