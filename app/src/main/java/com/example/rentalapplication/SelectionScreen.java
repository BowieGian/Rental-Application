package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionScreen extends AppCompatActivity {

    public void HousesOnClick(View view){
        displayHouses();
    }

    public void displayHouses(){
        Intent intent = new Intent (this, DisplayHouses.class );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
    }
}