package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rentalapplication.R;

public class FilterSelect extends AppCompatActivity {
    private Button house;
    private Button apartment;
    private Button room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_select);
    }

    public void displayHouses(View view) {
        Intent intent = new Intent(this, FilterHouse.class);
        startActivity(intent);
    }

    public void displayApartments(View view) {
        Intent intent = new Intent(this, FilterApartment.class);
        startActivity(intent);
    }

    public void displayPrivateRooms(View view) {
        Intent intent = new Intent(this, FilterRoom.class);
        startActivity(intent);
    }
}