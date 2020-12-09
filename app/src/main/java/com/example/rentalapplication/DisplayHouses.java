package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DisplayHouses extends AppCompatActivity {
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
        Intent intent = new Intent(DisplayHouses.this, ScreenPayment.class);
        startActivity(intent);
    }
}