package com.spotter.tutoring;

public class Tutor {
    private String name;
    private String subject;
    private double rating;

    public Tutor(String name, String subject, double rating) {
        this.name = name;
        this.subject = subject;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getRating() {
        return rating;
    }
}
