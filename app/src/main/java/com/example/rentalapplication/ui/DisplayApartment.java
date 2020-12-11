package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.Apartment;

public class DisplayApartment extends AppCompatActivity {
    private ImageView imageView;
    private Apartment apartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_apartment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        apartment = (Apartment) intent.getSerializableExtra("Apartment");
        displayImage();
    }

    private void displayImage() {
        imageView = findViewById(R.id.privateRoomImage);
        Glide.with(this).load(apartment.getImageUrl()).into(imageView);
    }

    public void selectApartmentOnClick(View view) {
        Intent intent = new Intent(DisplayApartment.this, Payment.class);
        intent.putExtra("key", apartment.getKey());
        intent.putExtra("rentalType", "Apartment");
        startActivity(intent);
    }
}