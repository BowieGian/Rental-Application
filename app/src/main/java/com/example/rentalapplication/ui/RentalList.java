package com.example.rentalapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rentalapplication.R;
import com.example.rentalapplication.data.Apartment;
import com.example.rentalapplication.data.House;
import com.example.rentalapplication.data.PrivateRoom;
import com.example.rentalapplication.data.Rental;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RentalList extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private String rentalType;

    ListView listViewRentals;
    List<Rental> rentalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_list);
        rootNode = FirebaseDatabase.getInstance();

        rentalList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Bundle extras = getIntent().getExtras();
        rentalType = extras.getString("rentalType");
        final String inDate = extras.getString("inDate");
        final String outDate = extras.getString("outDate");

        final String beds = extras.getString("beds");
        final String baths = extras.getString("baths");
        final String pet = extras.getString("pet");
        final String smoke = extras.getString("smoke");
        final String rating = extras.getString("rating");
        final String price = extras.getString("price");
        final String location = extras.getString("location");

        listViewRentals = (ListView) findViewById(R.id.listViewHouses);
        listViewRentals.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewRentals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (rentalType) {
                    case "Apartment":
                        Apartment apartment = (Apartment) parent.getItemAtPosition(position);
                        intent = new Intent(RentalList.this, DisplayApartment.class);
                        intent.putExtra("Apartment", apartment);
                        startActivity(intent);
                        break;
                    case "House":
                        House house = (House) parent.getItemAtPosition(position);
                        intent = new Intent(RentalList.this, DisplayHouse.class);
                        intent.putExtra("House", house);
                        startActivity(intent);
                        break;
                    case "PrivateRoom":
                        PrivateRoom privateRoom = (PrivateRoom) parent.getItemAtPosition(position);
                        intent = new Intent(RentalList.this, DisplayRoom.class);
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
                    String guests, rooms;
                    switch (rentalType) {
                        case "Apartment":
                            guests = extras.getString("guests");
                            rooms = extras.getString("rooms");
                            Apartment apartment = rentalSnapshot.getValue(Apartment.class);
                            if (compareApartment(apartment, location, inDate, outDate, guests, rooms, beds, baths, pet, smoke, rating, price))
                                rentalList.add(apartment);
                            break;
                        case "House":
                            guests = extras.getString("guests");
                            rooms = extras.getString("rooms");
                            House house = rentalSnapshot.getValue(House.class);
                            if (compareHouse(house, location, inDate, outDate, guests, rooms, beds, baths, pet, smoke, rating, price))
                                rentalList.add(house);
                            break;
                        case "PrivateRoom":
                            PrivateRoom privateRoom = rentalSnapshot.getValue(PrivateRoom.class);
                            if (comparePrivateRoom(privateRoom, location, inDate, outDate, beds, baths, pet, smoke, rating, price))
                                rentalList.add(privateRoom);
                    }
                }

                RentalLayout adapter = new RentalLayout(RentalList.this, rentalList);
                listViewRentals.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private boolean checkRentalInt(int number, String spinnerInput) {
        if (spinnerInput.equals("Select"))
            return true;
        else if (spinnerInput.equals("6+") && number < 6)
            return false;
        else
            return number == Integer.parseInt(spinnerInput);
    }

    private boolean compareApartment(Apartment apartment, String location, String inDate, String outDate,
                                     String numGuests, String numRooms, String numBeds, String numBaths,
                                     String petFriendly, String smokeFree,
                                     String inputRating, String inputPrice) {
        if (!location.equals("") && !location.equals(apartment.getLocation()))
            return false;
        if (!inDate.equals("Select") && !inDate.equals(apartment.getInDate()))
            return false;
        if (!outDate.equals("Select") && !outDate.equals(apartment.getOutDate()))
            return false;
        if (!checkRentalInt(apartment.getNumGuests(), numGuests))
            return false;
        if (!checkRentalInt(apartment.getNumRooms(), numRooms))
            return false;
        if (!checkRentalInt(apartment.getNumBeds(), numBeds))
            return false;
        if (!checkRentalInt(apartment.getNumBaths(), numBaths))
            return false;
        if (!petFriendly.equals("Select") && Boolean.getBoolean(petFriendly) != apartment.isPetFriendly())
            return false;
        if (!smokeFree.equals("Select") && Boolean.getBoolean(smokeFree) != apartment.isSmokeFree())
            return false;

        double rating = apartment.getRating();
        switch (inputRating) {
            case "1 - 2 stars":
                if (rating < 1 || rating > 2)
                    return false;
                break;
            case "2 - 3 stars":
                if (rating < 2 || rating > 3)
                    return false;
                break;
            case "3 - 4 stars":
                if (rating < 3 || rating > 4)
                    return false;
                break;
            case "4 - 5 stars":
                if (rating < 4 || rating > 5)
                    return false;
                break;
        }

        double price = apartment.getPrice();
        switch (inputPrice) {
            case "$50 - $150":
                if (price < 50.0 || price > 150.0)
                    return false;
                break;
            case "$150 - $250":
                if (price < 150.0 || price > 250.0)
                    return false;
                break;
            case "$250 - $500":
                if (price < 250.0 || price > 500.0)
                    return false;
                break;
            case "$500 +":
                if (price < 500.0)
                    return false;
                break;
        }
        return true;
    }

    private boolean compareHouse(House house, String location, String inDate, String outDate,
                                     String numGuests, String numRooms, String numBeds, String numBaths,
                                     String petFriendly, String smokeFree,
                                     String inputRating, String inputPrice) {
        if (!location.equals("") && !location.equals(house.getLocation()))
            return false;
        if (!inDate.equals("Select") && !inDate.equals(house.getInDate()))
            return false;
        if (!outDate.equals("Select") && !outDate.equals(house.getOutDate()))
            return false;
        if (!checkRentalInt(house.getNumGuests(), numGuests))
            return false;
        if (!checkRentalInt(house.getNumRooms(), numRooms))
            return false;
        if (!checkRentalInt(house.getNumBeds(), numBeds))
            return false;
        if (!checkRentalInt(house.getNumBaths(), numBaths))
            return false;
        if (!petFriendly.equals("Select") && Boolean.getBoolean(petFriendly) != house.isPetFriendly())
            return false;
        if (!smokeFree.equals("Select") && Boolean.getBoolean(smokeFree) != house.isSmokeFree())
            return false;

        double rating = house.getRating();
        switch (inputRating) {
            case "1 - 2 stars":
                if (rating < 1 || rating > 2)
                    return false;
                break;
            case "2 - 3 stars":
                if (rating < 2 || rating > 3)
                    return false;
                break;
            case "3 - 4 stars":
                if (rating < 3 || rating > 4)
                    return false;
                break;
            case "4 - 5 stars":
                if (rating < 4 || rating > 5)
                    return false;
                break;
        }

        double price = house.getPrice();
        switch (inputPrice) {
            case "$50 - $150":
                if (price < 50.0 || price > 150.0)
                    return false;
                break;
            case "$150 - $250":
                if (price < 150.0 || price > 250.0)
                    return false;
                break;
            case "$250 - $500":
                if (price < 250.0 || price > 500.0)
                    return false;
                break;
            case "$500 +":
                if (price < 500.0)
                    return false;
                break;
        }
        return true;
    }

    private boolean comparePrivateRoom(PrivateRoom privateRoom, String location, String inDate, String outDate,
                                     String numBeds, String numBaths,
                                     String petFriendly, String smokeFree,
                                     String inputRating, String inputPrice) {
        if (!location.equals("") && !location.equals(privateRoom.getLocation()))
            return false;
        if (!inDate.equals("Select") && !inDate.equals(privateRoom.getInDate()))
            return false;
        if (!outDate.equals("Select") && !outDate.equals(privateRoom.getOutDate()))
            return false;
        if (!checkRentalInt(privateRoom.getNumBeds(), numBeds))
            return false;
        if (!checkRentalInt(privateRoom.getNumBaths(), numBaths))
            return false;
        if (!petFriendly.equals("Select") && Boolean.getBoolean(petFriendly) != privateRoom.isPetFriendly())
            return false;
        if (!smokeFree.equals("Select") && Boolean.getBoolean(smokeFree) != privateRoom.isSmokeFree())
            return false;

        double rating = privateRoom.getRating();
        switch (inputRating) {
            case "1 - 2 stars":
                if (rating < 1 || rating > 2)
                    return false;
                break;
            case "2 - 3 stars":
                if (rating < 2 || rating > 3)
                    return false;
                break;
            case "3 - 4 stars":
                if (rating < 3 || rating > 4)
                    return false;
                break;
            case "4 - 5 stars":
                if (rating < 4 || rating > 5)
                    return false;
                break;
        }

        double price = privateRoom.getPrice();
        switch (inputPrice) {
            case "$50 - $150":
                if (price < 50.0 || price > 150.0)
                    return false;
                break;
            case "$150 - $250":
                if (price < 150.0 || price > 250.0)
                    return false;
                break;
            case "$250 - $500":
                if (price < 250.0 || price > 500.0)
                    return false;
                break;
            case "$500 +":
                if (price < 500.0)
                    return false;
                break;
        }
        return true;
    }
}