package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class SelectionFilterScreenH extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "SelectionFilterScreen";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private int inYear;
    private int inMonth;
    private int inDay;
    private int outYear;
    private int outMonth;
    private int outDay;
    private int guests;
    private int rooms;
    private int beds;
    private int baths;
    private boolean pet;
    private boolean smoke;
    private int rating;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_filter_screen_h);

        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                inYear = calendar.get(Calendar.YEAR);
                inMonth = calendar.get(Calendar.MONTH);
                inDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SelectionFilterScreenH.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener1,
                        inYear, inMonth, inDay);
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
                Calendar calendar = Calendar.getInstance();
                outYear = calendar.get(Calendar.YEAR);
                outMonth = calendar.get(Calendar.MONTH);
                outDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SelectionFilterScreenH.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener2,
                        outYear, outMonth, outDay);
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

        Spinner spinnerGuests = (Spinner) findViewById(R.id.spinnerGuests);
        spinnerGuests.setOnItemSelectedListener(this);
        Spinner spinnerRooms = (Spinner) findViewById(R.id.spinnerRooms);
        spinnerRooms.setOnItemSelectedListener(this);
        Spinner spinnerBeds = (Spinner) findViewById(R.id.spinnerBeds);
        spinnerBeds.setOnItemSelectedListener(this);
        Spinner spinnerBaths = (Spinner) findViewById(R.id.spinnerBaths);
        spinnerBaths.setOnItemSelectedListener(this);
        Spinner spinnerPet = (Spinner) findViewById(R.id.spinnerPet);
        spinnerPet.setOnItemSelectedListener(this);
        Spinner spinnerSmoke = (Spinner) findViewById(R.id.spinnerSmoke);
        spinnerSmoke.setOnItemSelectedListener(this);
        Spinner spinnerRating = (Spinner) findViewById(R.id.spinnerRating);
        spinnerRating.setOnItemSelectedListener(this);
        Spinner spinnerPrice = (Spinner) findViewById(R.id.spinnerPrice);
        spinnerPrice.setOnItemSelectedListener(this);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Numbers));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGuests.setAdapter(myAdaptor);
        spinnerRooms.setAdapter((myAdaptor));
        spinnerBeds.setAdapter((myAdaptor));
        spinnerBaths.setAdapter((myAdaptor));

        ArrayAdapter<String> myAdaptor2 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Yes_No));
        myAdaptor2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPet.setAdapter(myAdaptor2);
        spinnerSmoke.setAdapter(myAdaptor2);

        ArrayAdapter<String> myAdaptor3 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rating));
        myAdaptor3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRating.setAdapter(myAdaptor3);

        ArrayAdapter<String> myAdaptor4 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price));
        myAdaptor4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrice.setAdapter(myAdaptor4);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedString = parent.getItemAtPosition(position).toString();

        switch (parent.getId()) {
            case R.id.spinnerGuests:
                if (selectedString.equals("6+"))
                    guests = 7;
                else if (selectedString.equals("Select"))
                    break;
                else
                    guests = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerRooms:
                if (selectedString.equals("6+"))
                    rooms = 7;
                else if (selectedString.equals("Select"))
                    break;
                else
                    rooms = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerBeds:
                if (selectedString.equals("6+"))
                    beds = 7;
                else if (selectedString.equals("Select"))
                    break;
                else
                    beds = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerBaths:
                if (selectedString.equals("6+"))
                    baths = 7;
                else if (selectedString.equals("Select"))
                    break;
                else
                    baths = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerPet:
                if (selectedString.equals("True"))
                    pet = true;
                else if (selectedString.equals("False"))
                    pet = false;
                break;
            case R.id.spinnerSmoke:
                if (selectedString.equals("True"))
                    smoke = true;
                else if (selectedString.equals("False"))
                    smoke = false;
                break;
            case R.id.spinnerRating:
                switch (selectedString) {
                    case "1 - 2 stars":
                        rating = 1;
                        break;
                    case "2 - 3 stars":
                        rating = 2;
                        break;
                    case "3 - 4 stars":
                        rating = 3;
                        break;
                    case "4 - 5 stars":
                        rating = 4;
                        break;
                }
                break;
            case R.id.spinnerPrice:
                switch (selectedString) {
                    case "$50 - $150":
                        price = 1;
                        break;
                    case "$150 - $250":
                        price = 2;
                        break;
                    case "$250 - $500":
                        price = 3;
                        break;
                    case "$500 +":
                        price = 4;
                        break;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void housesOnClick(View view) {
        displayHouses();
    }

    public void displayHouses() {
        TextView textLocation = (TextView) findViewById(R.id.location);
        String location = textLocation.getText().toString();

        Intent intent = new Intent(this, ScreenRentalList.class);
        intent.putExtra("rentalType", "House");
        intent.putExtra("inYear", inYear);
        intent.putExtra("inMonth", inMonth);
        intent.putExtra("inDay", inDay);
        intent.putExtra("outYear", outYear);
        intent.putExtra("outMonth", outMonth);
        intent.putExtra("outDay", outDay);
        intent.putExtra("guests", guests);
        intent.putExtra("rooms", rooms);
        intent.putExtra("beds", beds);
        intent.putExtra("baths", baths);
        intent.putExtra("pet", pet);
        intent.putExtra("smoke", smoke);
        intent.putExtra("rating", rating);
        intent.putExtra("price", price);
        intent.putExtra("location", location);
        startActivity(intent);
    }
}
