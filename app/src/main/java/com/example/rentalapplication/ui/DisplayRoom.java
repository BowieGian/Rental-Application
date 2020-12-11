package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.PrivateRoom;

public class DisplayRoom extends AppCompatActivity {
    private ImageView imageView;
    private PrivateRoom privateRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_room);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        privateRoom = (PrivateRoom) intent.getSerializableExtra("PrivateRoom");
        displayImage();

        TextView textDescription = findViewById(R.id.textDescription);
        TextView textID = findViewById(R.id.textRentalID);
        TextView textLocation = findViewById(R.id.textLocation);
        TextView textBeds = findViewById(R.id.textBeds);
        TextView textBaths = findViewById(R.id.textBaths);
        TextView textSmokeFree = findViewById(R.id.textSmokeFree);
        TextView textPetFriendly = findViewById(R.id.textPetFriendly);
        TextView textRating = findViewById(R.id.textRating);
        TextView textPrice = findViewById(R.id.textPrice);

        String description = "Location:\nNumber of beds:\n" +
                "Number of baths:\nSmoke free:\nPet friendly:\nRating average:\nPrice per night:";
        String id = privateRoom.getKey();
        String location = privateRoom.getLocation();
        String beds = String.valueOf(privateRoom.getNumBeds());
        String baths = String.valueOf(privateRoom.getNumBaths());
        String smokeFree, petFriendly;
        if (privateRoom.isSmokeFree())
            smokeFree = "Yes";
        else
            smokeFree = "No";

        if (privateRoom.isPetFriendly())
            petFriendly = "Yes";
        else
            petFriendly = "No";
        String rating = String.valueOf(privateRoom.getRating());
        String price = String.valueOf(privateRoom.getPrice());

        textDescription.setText(description);
        textID.setText(id);
        textLocation.setText(location);
        textBeds.setText(beds);
        textBaths.setText(baths);
        textSmokeFree.setText(smokeFree);
        textPetFriendly.setText(petFriendly);
        textRating.setText(rating);
        textPrice.setText(price);
    }

    private void displayImage() {
        imageView = findViewById(R.id.image);
        Glide.with(this).load(privateRoom.getImageUrl()).into(imageView);
    }

    public void selectPrivateRoom(View view) {
        Intent intent = new Intent(DisplayRoom.this, Payment.class);
        intent.putExtra("key", privateRoom.getKey());
        intent.putExtra("rentalType", "PrivateRoom");
        startActivity(intent);
    }
}