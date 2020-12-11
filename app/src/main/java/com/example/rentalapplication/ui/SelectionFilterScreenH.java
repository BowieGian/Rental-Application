package com.example.rentalapplication.ui;

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
import android.widget.Toast;

import com.example.rentalapplication.R;

import java.util.Calendar;

public class SelectionFilterScreenH extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "SelectionFilterScreen";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private String inDate;
    private String outDate;
    private String guests;
    private String rooms;
    private String beds;
    private String baths;
    private String pet;
    private String smoke;
    private String rating;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_filter_screen_h);

        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SelectionFilterScreenH.this,
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

                inDate = month + "/" + day + "/" + year;
                mDisplayDate1.setText(inDate);
            }
        };

        mDisplayDate2 = (TextView) findViewById(R.id.tvDate2);
        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SelectionFilterScreenH.this,
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

                outDate = month + "/" + day + "/" + year;
                mDisplayDate2.setText(outDate);
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
    protected void onStart() {
        super.onStart();
        inDate = "Select";
        outDate = "Select";
        guests = "Select";
        rooms = "Select";
        beds = "Select";
        baths = "Select";
        pet = "Select";
        smoke = "Select";
        rating = "Select";
        price = "Select";
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedString = parent.getItemAtPosition(position).toString();

        switch (parent.getId()) {
            case R.id.spinnerGuests:
                guests = selectedString;
                break;
            case R.id.spinnerRooms:
                rooms = selectedString;
                break;
            case R.id.spinnerBeds:
                beds = selectedString;
                break;
            case R.id.spinnerBaths:
                baths = selectedString;
                break;
            case R.id.spinnerPet:
                pet = selectedString;
                break;
            case R.id.spinnerSmoke:
                smoke = selectedString;
                break;
            case R.id.spinnerRating:
                rating = selectedString;
                break;
            case R.id.spinnerPrice:
                price = selectedString;
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
        if(location.matches("")){// check for empty location
            Toast.makeText(this,"Please Enter a Valid Location!  ", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, ScreenRentalList.class);
            intent.putExtra("rentalType", "House");
            intent.putExtra("inDate", inDate);
            intent.putExtra("outDate", outDate);
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
}
