package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ScreenCreateAd extends AppCompatActivity {
    private static final String TAG = "ScreenCreateAd";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ad_screen);

        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ScreenCreateAd.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate1.setText(date);
            }
        };

        mDisplayDate2 = (TextView) findViewById(R.id.tvDate2);
        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ScreenCreateAd.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener2,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate2.setText(date);
            }
        };

        Spinner guests = (Spinner) findViewById(R.id.spinnerGuests);
        Spinner rooms = (Spinner) findViewById(R.id.spinnerRooms);
        Spinner beds = (Spinner) findViewById(R.id.spinnerBeds);
        Spinner baths = (Spinner) findViewById(R.id.spinnerBaths);
        Spinner pet = (Spinner) findViewById(R.id.spinnerPet);
        Spinner smoke = (Spinner) findViewById(R.id.spinnerSmoke);
        Spinner rating = (Spinner) findViewById(R.id.spinnerRating);
        Spinner price  = (Spinner) findViewById(R.id.spinnerPrice);
        Spinner rentalType = (Spinner) findViewById(R.id.spinner11);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(ScreenCreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Numbers));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guests.setAdapter(myAdaptor);
        rooms.setAdapter((myAdaptor));
        beds.setAdapter((myAdaptor));
        baths.setAdapter((myAdaptor));

        ArrayAdapter<String> myAdaptor2 = new ArrayAdapter<>(ScreenCreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Yes_No));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pet.setAdapter(myAdaptor2);
        smoke.setAdapter(myAdaptor2);

        ArrayAdapter<String> myAdaptor3 = new ArrayAdapter<>(ScreenCreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rating));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rating.setAdapter(myAdaptor3);

        ArrayAdapter<String> myAdaptor4 = new ArrayAdapter<>(ScreenCreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price));
        myAdaptor4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        price.setAdapter(myAdaptor4);

        ArrayAdapter<String> myAdaptor5 = new ArrayAdapter<>(ScreenCreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.RentalType));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rentalType.setAdapter(myAdaptor5);
    }

    public void displayToast2(View V) {
        Toast.makeText(ScreenCreateAd.this, "Ad has been successfully posted", Toast.LENGTH_SHORT).show();
    }
}
