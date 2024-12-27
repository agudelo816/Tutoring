package com.spotter.tutoring.ui.user;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.spotter.tutoring.R;

public class UserSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        // Find the TextView and Buttons by their IDs
        TextView welcomeText = findViewById(R.id.welcomeText);
        Button createUserButton = findViewById(R.id.createUserButton);
        Button loginUserButton = findViewById(R.id.loginUserButton);

        // Set click listener for Create User button
        createUserButton.setOnClickListener(v -> {
            Intent intent = new Intent(UserSelectionActivity.this, CreateUserActivity.class);
            startActivity(intent);
        });

        // Set click listener for Login User button
        loginUserButton.setOnClickListener(v -> {
            // Perform action for Login User
//            welcomeText.setText("Login User Button Clicked!");

            Log.d("UserSelectionActivity", "Button Clicked - login user");
            try {
            Intent intent = new Intent(UserSelectionActivity.this, LoginUserActivity.class);
            startActivity(intent);}
            catch(Exception exc ){
                Log.d("UserSelectionActivity", "issue opening login user activity -- "+exc.getMessage());
            }
        });
    }
}
