package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rentalapplication.R;

public class SelectionScreen extends AppCompatActivity {
    private String userID;


    ////Siavash
    private Button house;
    private Button apartment;
    private Button room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        userID = getIntent().getDataString();

        /////Siavash
        house = (Button) findViewById(R.id.HouseID);
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayHouses();
            }
        });

        apartment = (Button) findViewById(R.id.AptID);
        apartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayApartments();
            }
        });

        room = (Button) findViewById(R.id.PrivateRoomID);
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRooms();
            }
        });
    }

    //////Siavash
    public void displayHouses() {
        Intent intent = new Intent(this, SelectionFilterScreenH.class);
        startActivity(intent);
    }

    public void displayApartments() {
        Intent intent = new Intent(this, SelectionFilterScreenAP.class);
        startActivity(intent);
    }

    public void displayRooms() {
        Intent intent = new Intent(this, SelectionFilterScreenR.class);
        startActivity(intent);
    }
}