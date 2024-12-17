package com.spotter.tutoring.api;

import com.spotter.tutoring.api.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServiceInterface {
    @POST("users/create") // Replace with your actual API endpoint
    Call<Void> createUser(@Body User user);
}