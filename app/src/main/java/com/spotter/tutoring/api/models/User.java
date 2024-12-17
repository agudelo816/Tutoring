package com.spotter.tutoring.api.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
////@Getter
////@Setter
////@AllArgsConstructor
public class User {
    private String username;
    private String email;
    private String password;

    private String role;



    public User(String email, String username, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}