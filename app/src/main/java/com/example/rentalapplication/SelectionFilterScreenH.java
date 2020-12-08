package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SelectionFilterScreenH extends AppCompatActivity {

    private static final String TAG = "SelectionFilterScreen";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_filter_screen_h);

        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

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

                String date = month + "/" + day + "/" + year;
                mDisplayDate2.setText(date);
            }
        };



        Spinner guests = (Spinner) findViewById(R.id.spinner3);
        Spinner rooms = (Spinner) findViewById(R.id.spinner4);
        Spinner beds = (Spinner) findViewById(R.id.spinner5);
        Spinner baths = (Spinner) findViewById(R.id.spinner6);
        Spinner pet = (Spinner) findViewById(R.id.spinner7);
        Spinner smoke = (Spinner) findViewById(R.id.spinner8);
        Spinner rating = (Spinner) findViewById(R.id.spinner9);
        Spinner price  = (Spinner) findViewById(R.id.spinner10);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Numbers));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guests.setAdapter(myAdaptor);
        rooms.setAdapter((myAdaptor));
        beds.setAdapter((myAdaptor));
        baths.setAdapter((myAdaptor));

        ArrayAdapter<String> myAdaptor2 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Yes_No));
        myAdaptor2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pet.setAdapter(myAdaptor2);
        smoke.setAdapter(myAdaptor2);

        ArrayAdapter<String> myAdaptor3 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Rating));
        myAdaptor3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rating.setAdapter(myAdaptor3);

        ArrayAdapter<String> myAdaptor4 = new ArrayAdapter<>(SelectionFilterScreenH.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Price));
        myAdaptor4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        price.setAdapter(myAdaptor4);
    }
}
