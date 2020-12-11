package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.House;

public class DisplayHouse extends AppCompatActivity {
    private ImageView imageView;
    private House house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_house);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        house = (House) intent.getSerializableExtra("House");
        displayImage();

        TextView textDescription = findViewById(R.id.textDescription);
        TextView textID = findViewById(R.id.textRentalID);
        TextView textLocation = findViewById(R.id.textLocation);
        TextView textGuests = findViewById(R.id.textGuests);
        TextView textRooms = findViewById(R.id.textRooms);
        TextView textBeds = findViewById(R.id.textBeds);
        TextView textBaths = findViewById(R.id.textBaths);
        TextView textSmokeFree = findViewById(R.id.textSmokeFree);
        TextView textPetFriendly = findViewById(R.id.textPetFriendly);
        TextView textRating = findViewById(R.id.textRating);
        TextView textPrice = findViewById(R.id.textPrice);

        String description = "Location:\nNumber of guests:\nNumber of rooms:\nNumber of beds:\n" +
                "Number of baths:\nSmoke free:\nPet friendly:\nRating average:\nPrice per night:";
        String id = house.getKey();
        String location = house.getLocation();
        String guests = String.valueOf(house.getNumGuests());
        String rooms = String.valueOf(house.getNumRooms());
        String beds = String.valueOf(house.getNumBeds());
        String baths = String.valueOf(house.getNumBaths());
        String smokeFree, petFriendly;
        if (house.isSmokeFree())
            smokeFree = "Yes";
        else
            smokeFree = "No";

        if (house.isPetFriendly())
            petFriendly = "Yes";
        else
            petFriendly = "No";

        String rating = String.valueOf(house.getRating());
        String price = String.valueOf(house.getPrice());

        textDescription.setText(description);
        textID.setText(id);
        textLocation.setText(location);
        textGuests.setText(guests);
        textRooms.setText(rooms);
        textBeds.setText(beds);
        textBaths.setText(baths);
        textSmokeFree.setText(smokeFree);
        textPetFriendly.setText(petFriendly);
        textRating.setText(rating);
        textPrice.setText(price);
    }

    private void displayImage() {
        imageView = findViewById(R.id.image);
        Glide.with(this).load(house.getImageUrl()).into(imageView);
    }

    public void selectHouse(View view) {
        Intent intent = new Intent(DisplayHouse.this, Payment.class);
        intent.putExtra("key", house.getKey());
        intent.putExtra("rentalType", "House");
        startActivity(intent);
    }
}