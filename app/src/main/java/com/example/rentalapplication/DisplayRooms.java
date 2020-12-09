package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DisplayRooms extends AppCompatActivity {
    private ImageView imageView;
    private PrivateRoom privateRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rooms);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        privateRoom = (PrivateRoom) intent.getSerializableExtra("PrivateRoom");
        displayImage();
    }

    private void displayImage() {
        imageView = findViewById(R.id.privateRoomImage);
        Glide.with(this).load(privateRoom.getImageUrl()).into(imageView);
    }

    public void selectRoomOnClick(View view) {
        Intent intent = new Intent(DisplayRooms.this, ScreenPayment.class);
        startActivity(intent);
    }
}