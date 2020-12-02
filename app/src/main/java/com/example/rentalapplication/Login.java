package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    List<UserAccount> userAccountList;
    private TextView usernameText;
    private TextView passwordText;

    public void loginOnClick(View view){
        //execute selectOption() only if the login is valid otherwise display error
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        for (UserAccount userAccount : userAccountList) {
            if (userAccount.getUserName().equals(username) && userAccount.getPassword().equals(password))
                selectOption();
        }
        //display username & password do not match
    }

    public void selectOption(){
        Intent intent = new Intent (this, SelectionScreen.class ); // intent opens a new window
        startActivity(intent);
    }

    public void openNewUserScreen(){
        Intent intent = new Intent (this, NewUserScreen.class );
        startActivity(intent);
    }

    public void signUp(){
        TextView tv = (TextView)findViewById(R.id.NewUserID);

        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNewUserScreen();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        reference.orderByChild("userName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userAccountList.clear();

                for(DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    UserAccount userAccount = userSnapshot.getValue(UserAccount.class);

                    userAccountList.add(userAccount);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Seller");
        userAccountList = new ArrayList<>();
        usernameText = (EditText)findViewById(R.id.editTextTextPersonName);
        passwordText = (EditText)findViewById(R.id.editTextTextPassword);
    }
}