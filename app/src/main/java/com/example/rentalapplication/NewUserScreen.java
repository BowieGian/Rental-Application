package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewUserScreen extends AppCompatActivity {
    private EditText usernameText, emailText, passwordText;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private int ID;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_user_screen);
        usernameText = (EditText)findViewById(R.id.UsernameID);
        emailText = (EditText)findViewById(R.id.EmailID);
        passwordText = (EditText)findViewById(R.id.PasswordID);

        rootNode = FirebaseDatabase.getInstance(); // get the root node
        reference = rootNode.getReference("User"); // get the child node named User
    }

    public void SignUponclick(View view){
        //update database here add new user
        String username = usernameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        imageUrl = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/suburban-house-royalty-free-image-1584972559.jpg";

        UserAccount newUser = new UserAccount(ID, username, email, password, imageUrl); // create a new user

        //reference.push().setValue(newUser);  // add newUser as a child to the Node Seller
    }
}