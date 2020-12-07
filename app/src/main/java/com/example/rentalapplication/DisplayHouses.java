package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private DatabaseReference userRef;
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

    private UserAccount userAccount = new UserAccount();
    private String intVal;

    private Apartment tempApartment;
    private House tempHouse;
    private PrivateRoom tempPrivateRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);
        rootNode = FirebaseDatabase.getInstance();
        userRef = rootNode.getReference("Seller");
        displayHousesAndProperties();
        Intent mIntent = getIntent();
        intVal = mIntent.getStringExtra("intIndex");
        System.out.println("----------------index----------"+intVal);

        apartRef = rootNode.getReference("Apartment");
        houseRef = rootNode.getReference("House");
        pRoomRef = rootNode.getReference("PrivateRoom");
        rentalList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        rentalType = APARTMENT;

        switch(rentalType) {
            case APARTMENT:
                apartListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        rentalList.clear();

                        for(DataSnapshot apartmentSnapshot : dataSnapshot.getChildren()) {
                            Apartment apartment = apartmentSnapshot.getValue(Apartment.class);
                            rentalList.add(apartment);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };

                apartRef.orderByChild("location").addValueEventListener(apartListener);
                break;
            case HOUSE:

                break;
            case PRIVATE_ROOM:

                break;
        }
    }

    public void displayHousesAndProperties(){
        // display the data from database





    }

    public void SelectHouseOnClick(View view) {
        apartRef.child("-MNuXZzHdZrqlT3Eam5y").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tempApartment = dataSnapshot.getValue(Apartment.class);
                displayImage();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
    }

    private void displayImage() {
        imageView = findViewById(R.id.House1ImageID);
        Glide.with(this).load(tempApartment.getImageUrl()).into(imageView);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (apartListener != null)
            apartRef.removeEventListener(apartListener);
    }
}