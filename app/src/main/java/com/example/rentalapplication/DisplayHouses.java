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

public class DisplayHouses extends AppCompatActivity {

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private TextView imageUrl;
    private TextView userName;
    private TextView properties;
    private ImageView imageView;
     String intVal;
    private UserAccount userAccount = new UserAccount();

    public void displayHousesAndProperties(){
        // display the data from database





    }
    public void SelectHouseOnClick(View view ){

        reference.child(intVal).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userAccount = dataSnapshot.getValue(UserAccount.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
        imageView = findViewById(R.id.House1ImageID);
        Glide.with(this).load(userAccount.getImageUrl()).into(imageView);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Seller");
        displayHousesAndProperties();
        Intent mIntent = getIntent();
        intVal = mIntent.getStringExtra("intIndex");
        System.out.println("----------------index----------"+intVal);

    }
}