package com.example.rentalapplication;

public class UserAccount {
    int ID;
    String userName;
    String email;
    String password;
    String imageUrl;


    public UserAccount(){};

    public UserAccount(int ID, String userName, String email, String password, String imageUrl) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
