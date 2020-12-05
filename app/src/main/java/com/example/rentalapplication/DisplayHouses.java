package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

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
    private UserAccount userAccount = new UserAccount();

    public void displayOnClick(View view){
        // display the data from database
        /*
        reference.child("301326234").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               userAccount = dataSnapshot.getValue(UserAccount.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
        imageView = findViewById(R.id.googleImageId);
        Glide.with(this).load(userAccount.getImageUrl()).into(imageView);
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_houses);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Seller");

    }
}