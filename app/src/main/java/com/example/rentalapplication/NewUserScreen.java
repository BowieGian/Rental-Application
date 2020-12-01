package com.example.rentalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Random;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewUserScreen extends AppCompatActivity {
   private EditText username, email, password;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    private int ID;
    private String imageUrl;

public void SignUponclick(View view){
//update database here add new user
    rootNode = FirebaseDatabase.getInstance(); // get the root node
    reference = rootNode.getReference("Seller"); // get the child node named Seller
    Random rand = new Random();
    ID = 301326234; //+ rand.nextInt(100);
    imageUrl = "https://thefederal.com/file/2020/07/image-32.png";

    String UserName = username.getText().toString();
    String Email = email.getText().toString();
    String Password = password.getText().toString();
    UserAccount newUser = new UserAccount(ID,UserName, Email, Password ,imageUrl); // create a new user

    reference.child(Integer.toString(ID)).setValue(newUser);  // add newUser as a child to the Node Seller


}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_screen);
        username = (EditText)findViewById(R.id.UsernameID);
        email = (EditText)findViewById(R.id.EmailID);
        password = (EditText)findViewById(R.id.PasswordID);
    }
}