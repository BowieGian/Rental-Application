package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ScreenRentalList extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private String rentalType;

    ListView listViewRentals;
    List<Rental> rentalList;

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        rentalType = extras.getString("rentalType");
        int inYear = extras.getInt("inYear");
        int inMonth = extras.getInt("inMonth");
        int inDay = extras.getInt("inDay");
        int outYear = extras.getInt("outYear");
        int outMonth = extras.getInt("outMonth");
        int outDay = extras.getInt("outDay");
        int guests,  rooms;
        if (rentalType != "Room") {
            guests = extras.getInt("guests");
            rooms = extras.getInt("rooms");
        }
        int beds = extras.getInt("beds");
        int baths = extras.getInt("baths");
        boolean pet = extras.getBoolean("pet");
        boolean smoke = extras.getBoolean("smoke");
        int rating = extras.getInt("rating");
        final int price = extras.getInt("price");
        String location = extras.getString("location");

        listViewRentals = (ListView) findViewById(R.id.listViewHouses);
        listViewRentals.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewRentals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (rentalType) {
                    case "Apartment":
                        Apartment apartment = (Apartment) parent.getItemAtPosition(position);
                        intent = new Intent(ScreenRentalList.this, DisplayApartment.class);
                        intent.putExtra("Apartment", apartment);
                        startActivity(intent);
                        break;
                    case "House":
                        House house = (House) parent.getItemAtPosition(position);
                        intent = new Intent(ScreenRentalList.this, DisplayHouses.class);
                        intent.putExtra("House", house);
                        startActivity(intent);
                        break;
                    case "PrivateRoom":
                        PrivateRoom privateRoom = (PrivateRoom) parent.getItemAtPosition(position);
                        intent = new Intent(ScreenRentalList.this, DisplayRooms.class);
                        intent.putExtra("PrivateRoom", privateRoom);
                        startActivity(intent);
                        break;
                }
            }
        });


        reference = rootNode.getReference(rentalType);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rentalList.clear();

                for (DataSnapshot rentalSnapshot : dataSnapshot.getChildren()) {
                    switch (rentalType) {
                        case "Apartment":
                            Apartment apartment = rentalSnapshot.getValue(Apartment.class);
                            rentalList.add(apartment);
                            break;
                        case "House":
                            House house = rentalSnapshot.getValue(House.class);
                            rentalList.add(house);
                            break;
                        case "PrivateRoom":
                            PrivateRoom privateRoom = rentalSnapshot.getValue(PrivateRoom.class);
                            rentalList.add(privateRoom);
                    }
                }

                LayoutRental adapter = new LayoutRental(ScreenRentalList.this, rentalList);
                listViewRentals.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_list);
        rootNode = FirebaseDatabase.getInstance();

        rentalList = new ArrayList<>();
    }
}