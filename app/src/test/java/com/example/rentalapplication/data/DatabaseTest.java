package com.example.rentalapplication.data;

import com.example.rentalapplication.ui.LayoutRental;
import com.example.rentalapplication.ui.RentalList;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import androidx.annotation.NonNull;

public class DatabaseTest {
    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference apartRef = rootNode.getReference("Apartment");
    DatabaseReference pushRef;

    @Test
    void createApartment() {
        final Apartment apartment = new Apartment("InDate", "OutDate", 1, 2, 3, 4,
                true, true, "Location", 4.5, 500, "https://tinyurl.com/y4djsoze");

        pushRef = apartRef.push();
        apartment.setKey(pushRef.getKey());
        pushRef.setValue(apartment);

        pushRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot rentalSnapshot : dataSnapshot.getChildren()) {
                    Apartment apartmentFromDatabase = rentalSnapshot.getValue(Apartment.class);
                    Assert.assertEquals(apartmentFromDatabase, apartment, "Apartments are not the same!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
