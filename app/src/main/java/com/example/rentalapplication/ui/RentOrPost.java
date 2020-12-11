package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rentalapplication.R;

public class RentOrPost extends AppCompatActivity {

    private Button Rent;
    private Button Ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_or_post);

        Rent = (Button) findViewById(R.id.HouseID);
        Rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectionScreen();
            }
        });

        Ad = (Button) findViewById(R.id.AptID);
        Ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateAdScreen();
            }
        });
    }

    public void openSelectionScreen() {
        Intent intenta = new Intent(this, FilterSelect.class);
        startActivity(intenta);
    }

    public void openCreateAdScreen() {
        Intent intentb = new Intent(this, CreateAd.class);
        startActivity(intentb);
    }
}