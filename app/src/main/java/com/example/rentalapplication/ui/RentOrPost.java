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
    }

    //Links the user to the rentals screen
    public void rentScreen(View view) {
        Intent intent = new Intent(this, FilterSelect.class);
        startActivity(intent);
    }

    //Linking the user to the create post/ad screen
    public void createAdScreen(View view) {
        Intent intent = new Intent(this, CreateAd.class);
        startActivity(intent);
    }
}