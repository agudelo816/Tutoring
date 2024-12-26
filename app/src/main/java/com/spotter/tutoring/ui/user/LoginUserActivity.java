package com.spotter.tutoring.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.spotter.tutoring.R;
import com.spotter.tutoring.ui.tutor.SearchTutorsActivity;
import com.spotter.tutoring.ui.tutor.ViewAvailableTutorsActivity;

public class LoginUserActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        // Initialize UI elements
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);

        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginUserActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Log the input for debugging
                    Log.d("LoginUserActivity", "Email: " + email + ", Password: " + password);

                    // TODO: Add authentication logic here if needed

                }

                startViewAvailableTutorsActivity();
            }
        });
    }


    private void startViewAvailableTutorsActivity(){
        // Navigate to StudentActivity
//        Intent intent = new Intent(LoginUserActivity.this, ViewAvailableTutorsActivity.class);

        Intent intent = new Intent(LoginUserActivity.this, SearchTutorsActivity.class);

        startActivity(intent);
        finish();

    }
}
