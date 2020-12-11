package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.House;

public class DisplayHouse extends AppCompatActivity {
    private ImageView imageView;
    private House house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        house = (House) intent.getSerializableExtra("House");
        displayImage();
    }

    private void displayImage() {
        imageView = findViewById(R.id.houseImage);
        Glide.with(this).load(house.getImageUrl()).into(imageView);
    }

    public void selectHouseOnClick(View view) {
        Intent intent = new Intent(DisplayHouse.this, Payment.class);
        intent.putExtra("key", house.getKey());
        intent.putExtra("rentalType", "House");
        startActivity(intent);
    }
}