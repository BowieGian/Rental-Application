package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScreenPayment extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private String rentalType;
    private String key;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);
        rootNode = FirebaseDatabase.getInstance();

        Spinner PaymentType = (Spinner) findViewById(R.id.spinnera);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(ScreenPayment.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PaymentType));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PaymentType.setAdapter(myAdaptor);

        goBack = (Button) findViewById(R.id.button3);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToStart();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        key = extras.getString("key");
        rentalType = extras.getString("rentalType");
    }

    public void displayToast(View v) {
        reference = rootNode.getReference(rentalType);
        reference.child(key).removeValue();
        Toast.makeText(ScreenPayment.this, "Your payment was been completed", Toast.LENGTH_SHORT).show();
    }

    public void goBackToStart() {
        Intent intent = new Intent(this, UserType.class);
        startActivity(intent);
    }
}