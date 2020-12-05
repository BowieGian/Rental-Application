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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Login extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;
    List<UserAccount> userAccountList;
    private TextView usernameText;
    private TextView passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("User");
        userAccountList = new ArrayList<>();
        usernameText = (EditText)findViewById(R.id.editTextTextPersonName);
        passwordText = (EditText)findViewById(R.id.editTextTextPassword);
    }

    public void loginOnClick(View view){
        //execute selectOption() only if the login is valid otherwise display error
        String username = usernameText.getText().toString();
        final String password = passwordText.getText().toString();

        reference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null)
                    return;

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    UserAccount userAccount = userSnapshot.getValue(UserAccount.class);

                    if (userAccount == null)
                        return;

                    if (userAccount.getPassword().equals(password))
                        selectOption();

                    //display username & password do not match
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
}