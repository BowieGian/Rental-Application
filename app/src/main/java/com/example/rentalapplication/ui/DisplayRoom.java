package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    }

    private void displayImage() {
        imageView = findViewById(R.id.privateRoomImage);
        Glide.with(this).load(privateRoom.getImageUrl()).into(imageView);
    }

    public void selectRoomOnClick(View view) {
        Intent intent = new Intent(DisplayRoom.this, Payment.class);
        intent.putExtra("key", privateRoom.getKey());
        intent.putExtra("rentalType", "PrivateRoom");
        startActivity(intent);
    }
}