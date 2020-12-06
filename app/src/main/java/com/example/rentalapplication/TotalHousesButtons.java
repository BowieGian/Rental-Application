package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TotalHousesButtons extends AppCompatActivity {

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private int NumberofHouses = 0;
    private int index =0;
    private String intVal = "301326234";


  public void populatebuttons( int NumberofHouses){
        TableLayout table = (TableLayout)findViewById(R.id.tableForButtons);
        for( int rows = 0; rows<NumberofHouses; rows++) {

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            table.addView(tableRow);

            for ( int cols = 0; cols < 1; cols++) {

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                index = rows * 1 + cols;
                button.setText("House# "+ index);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent myIntent = new Intent(TotalHousesButtons.this, DisplayHouses.class);
                        myIntent.putExtra("intIndex", intVal);
                        startActivity(myIntent);

                    }
                });
                tableRow.addView(button);
            }

        }
  }
  public void openDisplayHouses(String intValue){


  }
    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                NumberofHouses = (int) dataSnapshot.getChildrenCount()+20;

                populatebuttons(NumberofHouses);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_houses_buttons);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Seller");

    }


}