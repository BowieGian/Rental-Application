package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PaymentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);

        Spinner PaymentType = (Spinner) findViewById(R.id.spinnera);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(PaymentScreen.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PaymentType));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PaymentType.setAdapter(myAdaptor);
    }

    public void displayToast(View v){
        Toast.makeText(PaymentScreen.this, "Your payment was been completed", Toast.LENGTH_SHORT).show();
    }
}