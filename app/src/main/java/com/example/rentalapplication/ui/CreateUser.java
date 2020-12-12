package com.example.rentalapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.rentalapplication.R;
import com.example.rentalapplication.data.UserAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateUser extends AppCompatActivity {
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private String username;
    private String email;
    private String password;

    private DatabaseReference userRef;

    public void BackToLogin(){
        Intent intent = new Intent (this, Login.class ); // intent opens a new window
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_user);
        usernameText = findViewById(R.id.textUsername);
        emailText = findViewById(R.id.textEmail);
        passwordText = findViewById(R.id.textPassword);

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance(); // get the root node
        userRef = rootNode.getReference("User"); // get the child node named User
    }

    public void SignUpOnclick(View view){
        //update database here add new user
        username = usernameText.getText().toString();
        email = emailText.getText().toString();
        password = passwordText.getText().toString();


        userRef.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            //Looking after different scenario cases in the Create User screen
            //User needs to fill all the fields
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(username.matches("")||email.matches("")||password.matches("")){
                    Toast.makeText(CreateUser.this,"Please complete all the required fields!  ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //if the username is not taken
                    if (dataSnapshot.getValue() == null) {
                        UserAccount newUser = new UserAccount(username, email, password);
                        userRef.push().setValue(newUser);  // add newUser as a child to the Node User
                        Toast.makeText(CreateUser.this,"Account created Successfully! ", Toast.LENGTH_SHORT).show();
                        BackToLogin();
                    }
                    //if the entered credentials are not valid
                    else {
                        Toast.makeText(CreateUser.this,"Please Enter Valid Credentials!  ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}