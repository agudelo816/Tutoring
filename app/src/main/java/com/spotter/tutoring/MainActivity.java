package com.spotter.tutoring;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView and Buttons by their IDs
        TextView welcomeText = findViewById(R.id.welcomeText);
        Button createUserButton = findViewById(R.id.createUserButton);
        Button loginUserButton = findViewById(R.id.loginUserButton);

        // Set click listener for Create User button
        createUserButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
            startActivity(intent);
        });

        // Set click listener for Login User button
        loginUserButton.setOnClickListener(v -> {
            // Perform action for Login User
            welcomeText.setText("Login User Button Clicked!");
        });
    }
}
