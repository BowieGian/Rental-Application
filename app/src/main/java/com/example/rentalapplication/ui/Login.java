package com.example.rentalapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rentalapplication.R;
import com.example.rentalapplication.data.UserAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Toast;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private FirebaseDatabase rootNode;
    private DatabaseReference userRef;
    private TextView usernameText;
    private TextView passwordText;
    private UserAccount currentUser;
    private DatabaseReference houseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp();
        rootNode = FirebaseDatabase.getInstance();
        userRef = rootNode.getReference("User");
        usernameText = (EditText)findViewById(R.id.textUsername);
        passwordText = (EditText)findViewById(R.id.textPassword);
    }

    public void loginOnClick(View view){
        //execute selectOption() only if the login is valid otherwise display error
        String username = usernameText.getText().toString();
        final String password = passwordText.getText().toString();
        if(username.equals("")||password.equals("")){
            Toast.makeText(Login.this,"Invalid credentials", Toast.LENGTH_SHORT).show();
        }
        else{
            userRef.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        invalidCredentials();
                        return;
                    }

                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        currentUser = userSnapshot.getValue(UserAccount.class);

                        //Case of empty username
                        if (currentUser == null) {
                            invalidCredentials();
                            return;
                        }

                        //Matching the username with the password
                        if (currentUser.getPassword().equals(password)) {
                            selectOption();
                            return;
                        }
                    }
                    invalidCredentials();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    //Case of invalid login credentials
    private void invalidCredentials() {
        Toast.makeText(Login.this,"Invalid credentials", Toast.LENGTH_SHORT).show();
    }


    public void selectOption(){
        Intent intent = new Intent (Login.this, RentOrPost.class ); // intent opens a new window
        startActivity(intent);
    }

    //Linking to the Create new user screen
    public void openNewUserScreen(){
        Intent intent = new Intent (this, CreateUser.class );
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