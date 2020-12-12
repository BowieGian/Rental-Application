package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

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

public class FilterRoom extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "FilterRoom";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private String inDate;
    private String outDate;
    private String beds;
    private String baths;
    private String pet;
    private String smoke;
    private String rating;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_room);

        //This is the Calendar part of the UI which allows the user to
        //pick their arrival date using the Calendar like option
        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FilterRoom.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener1,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        //Action listener for the button so it opens up the Calendar view
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                inDate = month + "/" + day + "/" + year;
                mDisplayDate1.setText(inDate);
            }
        };

        //This is the Calendar part of the UI which allows the user to
        //pick their checkout date using the Calendar like option
        mDisplayDate2 = (TextView) findViewById(R.id.tvDate2);
        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FilterRoom.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener2,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        //Action listener for the button so it opens up the Calendar view
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                outDate = month + "/" + day + "/" + year;
                mDisplayDate2.setText(outDate);
            }
        };

        //Adding all the Spinners for the drop down menus so the user can enter
        //the data easier since most of them are predefine
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

        //Passing the correct array define for each spinner based on their data input
        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(FilterRoom.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Numbers));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBeds.setAdapter((myAdaptor));
        spinnerBaths.setAdapter((myAdaptor));

        //Passing the correct array define for each spinner based on their data input
        ArrayAdapter<String> myAdaptor2 = new ArrayAdapter<>(FilterRoom.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Select_Yes_No));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPet.setAdapter(myAdaptor2);
        spinnerSmoke.setAdapter(myAdaptor2);

        //Passing the correct array define for each spinner based on their data input
        ArrayAdapter<String> myAdaptor3 = new ArrayAdapter<>(FilterRoom.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rating));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRating.setAdapter(myAdaptor3);

        //Passing the correct array define for each spinner based on their data input
        ArrayAdapter<String> myAdaptor4 = new ArrayAdapter<>(FilterRoom.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrice.setAdapter(myAdaptor4);
    }

    @Override
    protected void onStart() {
        //Defining some parameters to store the users data from the spinners
        super.onStart();
        inDate = "Select";
        outDate = "Select";
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

        //Getting the user inputs from the spinners and store them
        switch (parent.getId()) {
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

    public void roomsOnClick(View view) {
        displayRooms();
    }

    public void displayRooms() {
        TextView textLocation = (TextView) findViewById(R.id.location);
        String location = textLocation.getText().toString();

        //Case of invalid location:
        if(location.matches("")){// check for empty location
            Toast.makeText(this,"Please Enter a Valid Location!  ", Toast.LENGTH_SHORT).show();
        }

        //The case that everything have been entered correctly:
        else{
            Intent intent = new Intent(this, RentalList.class);
            intent.putExtra("rentalType", "PrivateRoom");
            intent.putExtra("inDate", inDate);
            intent.putExtra("outDate", outDate);
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
