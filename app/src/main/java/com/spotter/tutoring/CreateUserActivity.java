package com.spotter.tutoring;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;


import com.spotter.tutoring.api.ApiServiceInterface;
import com.spotter.tutoring.api.ApiClient;
import com.spotter.tutoring.api.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        // Find the form fields and button
        EditText usernameField = findViewById(R.id.usernameField);
        EditText emailField = findViewById(R.id.emailField);
        EditText passwordField = findViewById(R.id.passwordField);
        Spinner roleSpinner = findViewById(R.id.roleSpinner);
        Button submitButton = findViewById(R.id.submitButton);

        // Create an ArrayAdapter using a simple list of strings (roles)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the spinner
        roleSpinner.setAdapter(adapter);

        // Handle spinner item selection
        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // You can get the selected role using parentView.getItemAtPosition(position)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle case where nothing is selected (if necessary)
            }
        });


        // Set click listener for the Submit button
        submitButton.setOnClickListener(v -> {
            // Get input values
            String email = emailField.getText().toString().trim();
            String username = usernameField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();
            String role = roleSpinner.getSelectedItem().toString(); // Get selected role


            // Validate inputs
            if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(CreateUserActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(CreateUserActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("CreateUserActivity", "Username: " + username);
            Log.d("CreateUserActivity", "Email: " + email);
            Log.d("CreateUserActivity", "Password: " + password);
            Log.d("CreateUserActivity", "Role: " + role);

            // Here you can make the API call to create a user
            createUser(email, username, password, role);
        });
    }

    private void createUser(String email, String username, String password, String role) {
        ApiServiceInterface apiService = ApiClient.getClient(this).create(ApiServiceInterface.class);

        // Create a User object with email, username, and password
        User user = new User(email, username, password, role);

        Call<Void> call = apiService.createUser(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CreateUserActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, finish the activity or redirect to another screen
                    finish(); // Closes the current activity
                } else {
                    Toast.makeText(CreateUserActivity.this, "Failed to create user: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("CreateUserActivity", "Error: " + t.getMessage());
                Toast.makeText(CreateUserActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
