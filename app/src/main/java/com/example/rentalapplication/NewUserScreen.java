package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewUserScreen extends AppCompatActivity {
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private String username;
    private String email;
    private String password;

    private FirebaseDatabase rootNode;
    private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_user_screen);
        usernameText = (EditText)findViewById(R.id.UsernameID);
        emailText = (EditText)findViewById(R.id.EmailID);
        passwordText = (EditText)findViewById(R.id.PasswordID);

        rootNode = FirebaseDatabase.getInstance(); // get the root node
        userRef = rootNode.getReference("User"); // get the child node named User
    }

    public void SignUpOnclick(View view){
        //update database here add new user
        username = usernameText.getText().toString();
        email = emailText.getText().toString();
        password = passwordText.getText().toString();

        userRef.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // if the username is not taken
                if (dataSnapshot.getValue() == null) {
                    UserAccount newUser = new UserAccount(username, email, password);
                    userRef.push().setValue(newUser);  // add newUser as a child to the Node User
                }
                else {
                    // username is taken
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}