package com.example.rentalapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentalapplication.R;
import com.example.rentalapplication.data.Apartment;
import com.example.rentalapplication.data.House;
import com.example.rentalapplication.data.PrivateRoom;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CreateAd extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String TAG = "CreateAd";
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;

    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private String inDate = "Select";
    private String outDate = "Select";
    private int guests = -1;
    private int rooms = -1;
    private int beds = -1;
    private int baths = -1;
    private boolean pet = true;
    private boolean smoke = true;
    private String rentalType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ad);

        mDisplayDate1 = (TextView) findViewById(R.id.tvDate);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(CreateAd.this,
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

                DatePickerDialog dialog = new DatePickerDialog(CreateAd.this,
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
        TextView textViewAdPrice = (TextView) findViewById(R.id.textViewPrice);

        Spinner spinnerRentalType = (Spinner) findViewById(R.id.spinnerRentalType);
        spinnerRentalType.setOnItemSelectedListener(this);

        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(CreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Numbers));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGuests.setAdapter(myAdaptor);
        spinnerRooms.setAdapter((myAdaptor));
        spinnerBeds.setAdapter((myAdaptor));
        spinnerBaths.setAdapter((myAdaptor));

        ArrayAdapter<String> myAdaptor2 = new ArrayAdapter<>(CreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Yes_No));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPet.setAdapter(myAdaptor2);
        spinnerSmoke.setAdapter(myAdaptor2);

        ArrayAdapter<String> myAdaptor5 = new ArrayAdapter<>(CreateAd.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.RentalType));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRentalType.setAdapter(myAdaptor5);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedString = parent.getItemAtPosition(position).toString();

        switch (parent.getId()) {
            case R.id.spinnerGuests:
                if (selectedString.equals("6+"))
                    guests = 7;
                else if (selectedString.equals("Select")) {
                    guests = -1;
                    break;
                }
                else
                    guests = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerRooms:
                if (selectedString.equals("6+"))
                    rooms = 7;
                else if (selectedString.equals("Select")) {
                    rooms = -1;
                    break;
                }
                else
                    rooms = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerBeds:
                if (selectedString.equals("6+"))
                    beds = 7;
                else if (selectedString.equals("Select")) {
                    beds = -1;
                    break;
                }
                else
                    beds = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerBaths:
                if (selectedString.equals("6+"))
                    baths = 7;
                else if (selectedString.equals("Select")) {
                    baths = -1;
                    break;
                }
                else
                    baths = Integer.parseInt(selectedString);
                break;
            case R.id.spinnerPet:
                if (selectedString.equals("Yes"))
                    pet = true;
                else if (selectedString.equals("No"))
                    pet = false;
                break;
            case R.id.spinnerSmoke:
                if (selectedString.equals("Yes"))
                    smoke = true;
                else if (selectedString.equals("No"))
                    smoke = false;
                break;
            case R.id.spinnerRentalType:
                rentalType = selectedString;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void postAd(View V) {
        EditText editTextLocation = findViewById(R.id.editTextLocation);
        EditText editTextImageUrl = findViewById(R.id.editTextImageUrl);
        EditText textViewPrice = findViewById(R.id.textViewPrice);
        String location = editTextLocation.getText().toString();
        String imageUrl = editTextImageUrl.getText().toString();
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference pushRef;

        String temp = textViewPrice.getText().toString();
        int price;
        if (temp.equals(""))
            price = -1;
        else
            price = Integer.parseInt(temp);

        if (rentalType.equals("Select"))
            Toast.makeText(CreateAd.this, "Please select the rental type! ", Toast.LENGTH_SHORT).show();
        else if (imageUrl.matches("")||location.matches(""))
            Toast.makeText(CreateAd.this, "Please enter Valid image URL or Location! ", Toast.LENGTH_SHORT).show();
        else if (guests < 0)
            Toast.makeText(CreateAd.this, "Please select the number of guests! ", Toast.LENGTH_SHORT).show();
        else if (rooms < 0)
            Toast.makeText(CreateAd.this, "Please select the number of rooms! ", Toast.LENGTH_SHORT).show();
        else if (beds < 0)
            Toast.makeText(CreateAd.this, "Please select the number of beds! ", Toast.LENGTH_SHORT).show();
        else if (baths < 0)
            Toast.makeText(CreateAd.this, "Please select the number of baths! ", Toast.LENGTH_SHORT).show();
        else if (price <= 0)
            Toast.makeText(CreateAd.this, "Please enter Valid Price! ", Toast.LENGTH_SHORT).show();
        else {
            switch(rentalType) {
                case "Apartment":
                    Apartment apartment = new Apartment(inDate, outDate,
                            guests, rooms, beds, baths, pet, smoke, location, 0, price, imageUrl);
                    DatabaseReference apartRef = rootNode.getReference("Apartment");
                    pushRef = apartRef.push();
                    apartment.setKey(pushRef.getKey());
                    pushRef.setValue(apartment);
                    Toast.makeText(CreateAd.this, "Ad has been successfully posted", Toast.LENGTH_SHORT).show();
                    break;
                case "House":
                    House house = new House(inDate, outDate,
                            guests, rooms, beds, baths, pet, smoke, location, 0, price, imageUrl);
                    DatabaseReference houseRef = rootNode.getReference("House");
                    pushRef = houseRef.push();
                    house.setKey(pushRef.getKey());
                    pushRef.setValue(house);
                    Toast.makeText(CreateAd.this, "Ad has been successfully posted", Toast.LENGTH_SHORT).show();
                    break;
                case "Room":
                    PrivateRoom privateRoom = new PrivateRoom(inDate, outDate,
                            beds, baths, pet, smoke, location, 0, price, imageUrl);
                    DatabaseReference pRoomRef = rootNode.getReference("PrivateRoom");
                    pushRef = pRoomRef.push();
                    privateRoom.setKey(pushRef.getKey());
                    pushRef.setValue(privateRoom);
                    Toast.makeText(CreateAd.this, "Ad has been successfully posted", Toast.LENGTH_SHORT).show();
                    break;
            }

        }

    }
}
