package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rentalapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private String rentalType;
    private String key;
    private Button goBack;

    @Override
    //UI components
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        rootNode = FirebaseDatabase.getInstance();

        Spinner PaymentType = (Spinner) findViewById(R.id.spinnera);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(Payment.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PaymentType));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PaymentType.setAdapter(myAdaptor);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        key = extras.getString("key");
        rentalType = extras.getString("rentalType");
    }

    //Displays a toast message when the payment is successful
    public void displayToast(View v) {
        reference = rootNode.getReference(rentalType);
        reference.child(key).removeValue();
        Toast.makeText(Payment.this, "Your payment was been completed", Toast.LENGTH_SHORT).show();
    }

    //Once the payment is done, it takes the users to the main screen
    public void goBackToStart(View view) {
        Intent intent = new Intent(this, RentOrPost.class);
        startActivity(intent);
    }

    //The user can log out if they are done
    public void logOut(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}