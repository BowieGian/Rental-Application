package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserType extends AppCompatActivity {

    public void RentOnClick(View view){
        Intent intent = new Intent (this, SelectionScreen.class ); // intent opens a new window
        startActivity(intent);
    }
    public void AdOnClick(View view){
    //Still have to create new activity PostAd

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
    }
}