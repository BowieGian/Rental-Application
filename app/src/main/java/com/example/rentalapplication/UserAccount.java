package com.example.rentalapplication;

import com.google.firebase.database.DatabaseReference;

public class UserAccount {
    private String id;
    private String username;
    private String email;
    private String password;

    public UserAccount() {

    };

    public UserAccount(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addApart(DatabaseReference apartRef, String inDate, String outDate,
                         int numRooms, int numGuests, int numBathrooms, int numBeds,
                         boolean petFriendly, boolean smokeFree, String location) {
        Apartment newApart = new Apartment(inDate, outDate, petFriendly, smokeFree, location);
        newApart.setNumRooms(numRooms);
        newApart.setNumGuests(numGuests);
        newApart.setNumBathrooms(numBathrooms);
        newApart.setNumBeds(numBeds);

        apartRef.push().setValue(newApart);
    }
}
