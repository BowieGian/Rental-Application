package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ScreenHouseButtons extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    ListView listViewHouses;
    List<House> houseList;

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        int guests = extras.getInt("Guests");
        int rooms = extras.getInt("Rooms");
        int beds = extras.getInt("Beds");
        int baths = extras.getInt("Baths");
        boolean pet = extras.getBoolean("Pet");
        boolean smoke = extras.getBoolean("Smoke");
        int rating = extras.getInt("Rating");
        int price = extras.getInt("Price");
        String location = extras.getString("Location");

        listViewHouses = (ListView) findViewById(R.id.listViewHouses);
        listViewHouses.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewHouses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                House house = (House) parent.getItemAtPosition(position);

                Intent intent = new Intent(ScreenHouseButtons.this, DisplayHouses.class);
                intent.putExtra("House", house);
                startActivity(intent);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                houseList.clear();

                for (DataSnapshot houseSnapshot : dataSnapshot.getChildren()) {
                    House house = houseSnapshot.getValue(House.class);
                    houseList.add(house);
                }

                LayoutHouse adapter = new LayoutHouse(ScreenHouseButtons.this, houseList);
                listViewHouses.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_buttons);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("House");

        houseList = new ArrayList<>();
    }
}