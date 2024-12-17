package com.spotter.tutoring.api;

import android.content.Context;

import com.spotter.tutoring.api.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiService {

    private ApiServiceInterface apiServiceInterface;

    public ApiService(Context context) {
        // Get the Retrofit client with custom OkHttpClient
        apiServiceInterface = ApiClient.getClient(context).create(ApiServiceInterface.class);
    }

    // Example method to make a POST request to create a user
    public void createUser(User user) {
        Call<Void> call = apiServiceInterface.createUser(user); // Assume createUser() is defined in your API interface
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Handle success
                } else {
                    // Handle failure
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle error
            }
        });
    }
}
