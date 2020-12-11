package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.Apartment;

public class DisplayApartment extends AppCompatActivity {
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

        TextView textDescription = findViewById(R.id.textDescription);
        TextView textID = findViewById(R.id.textRentalID);
        TextView textLocation = findViewById(R.id.textRentalList);
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
        String id = apartment.getKey();
        String location = apartment.getLocation();
        String guests = String.valueOf(apartment.getNumGuests());
        String rooms = String.valueOf(apartment.getNumRooms());
        String beds = String.valueOf(apartment.getNumBeds());
        String baths = String.valueOf(apartment.getNumBaths());
        String smokeFree, petFriendly;
        if (apartment.isSmokeFree())
            smokeFree = "Yes";
        else
            smokeFree = "No";

        if (apartment.isPetFriendly())
            petFriendly = "Yes";
        else
            petFriendly = "No";

        String rating = String.valueOf(apartment.getRating());
        String price = String.valueOf(apartment.getPrice());

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
        ImageView imageView = findViewById(R.id.image);
        Glide.with(this).load(apartment.getImageUrl()).into(imageView);
    }

    public void selectApartment(View view) {
        Intent intent = new Intent(DisplayApartment.this, Payment.class);
        intent.putExtra("key", apartment.getKey());
        intent.putExtra("rentalType", "Apartment");
        startActivity(intent);
    }
}