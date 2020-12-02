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

    public void loginOnClick(View view){
        //execute selectOption() only if the login is valid otherwise display error
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        UserAccount compareAccount = new UserAccount();
        compareAccount.setUserName(username);

        Comparator<UserAccount> compareUsername = new Comparator<UserAccount>() {
            @Override
            public int compare(UserAccount o1, UserAccount o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        };

        int index = Collections.binarySearch(userAccountList, compareAccount, compareUsername);
        if (index >= 0)
            if (userAccountList.get(index).getPassword().equals(password))
                selectOption();
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