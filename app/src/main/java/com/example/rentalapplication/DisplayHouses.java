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
    private TextView imageUrl;
    private TextView userName;
    private TextView properties;
    private ImageView imageView;

    private UserAccount userAccount = new UserAccount();

    private House house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);

        Intent intent = getIntent();
        house = (House) intent.getSerializableExtra("House");
        displayImage();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void SelectHouseOnClick(View view) {

    }

    private void displayImage() {
        imageView = findViewById(R.id.House1ImageID);
        Glide.with(this).load(house.getImageUrl()).into(imageView);
    }
}