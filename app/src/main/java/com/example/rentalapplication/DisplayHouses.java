package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DisplayHouses extends AppCompatActivity {

    private FirebaseDatabase rootNode;
    private DatabaseReference apartRef;
    private DatabaseReference houseRef;
    private DatabaseReference pRoomRef;
    private ValueEventListener apartListener;
    private ValueEventListener houseListener;
    private ValueEventListener pRoomListener;

    private TextView imageUrl;
    private TextView userName;
    private TextView properties;
    private ImageView imageView;

    public final int APARTMENT = 1;
    public final int HOUSE = 2;
    public final int PRIVATE_ROOM = 3;
    private int rentalType = 0;
    private List<Rental> rentalList;

    private Apartment tempApartment;
    private House tempHouse;
    private PrivateRoom tempPrivateRoom;
    //private UserAccount userAccount = new UserAccount();

    public void displayOnClick(View view){
        // display the data from database
        /*
        reference.child("301326234").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               userAccount = dataSnapshot.getValue(UserAccount.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
        imageView = findViewById(R.id.googleImageId);
        Glide.with(this).load(userAccount.getImageUrl()).into(imageView);
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);
        rootNode = FirebaseDatabase.getInstance();
        apartRef = rootNode.getReference("Apartment");
        houseRef = rootNode.getReference("House");
        pRoomRef = rootNode.getReference("PrivateRoom");

        tempApartment = new Apartment("Address", "Location", "Availability", true, true, true, "Contact", true);
        tempHouse = new House("Address", "Location", "Availability", true, true, true, "Contact", true);
        tempPrivateRoom = new PrivateRoom("Address", "Location", "Availability", true, true, true, "Contact", true);
        //addApartment(tempApartment);
        //addHouse(tempHouse);
        //addPrivateRoom(tempPrivateRoom);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (apartListener != null)
            apartRef.removeEventListener(apartListener);
    }

    // move to post ad screen
    public void addApartment(Apartment apartment) {
        apartRef.push().setValue(apartment);
    }

    public void addHouse(House house) {
        houseRef.push().setValue(house);
    }

    public void addPrivateRoom(PrivateRoom privateRoom) {
        pRoomRef.push().setValue(privateRoom);
    }
}