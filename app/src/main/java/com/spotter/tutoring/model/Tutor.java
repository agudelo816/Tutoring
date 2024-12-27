package com.spotter.tutoring.model;
import android.os.Parcel;
import android.os.Parcelable;

public class Tutor implements Parcelable {
    private String name;
    private String subject;
    private double rating;

    private String email;

    public Tutor(String name, String subject, double rating) {
        this.name = name;
        this.subject = subject;
        this.rating = rating;
        this.email = "generic@email.com";
    }

    public Tutor(String name, String subject, double rating, String email) {
        this.name = name;
        this.subject = subject;
        this.rating = rating;
        this.email = email;
    }

    protected Tutor(Parcel in) {
        name = in.readString();
        subject = in.readString();
        rating = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(subject);
        dest.writeDouble(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tutor> CREATOR = new Creator<Tutor>() {
        @Override
        public Tutor createFromParcel(Parcel in) {
            return new Tutor(in);
        }

        @Override
        public Tutor[] newArray(int size) {
            return new Tutor[size];
        }
    };

    // Getters and setters (if needed)
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getRating() {
        return rating;
    }

    public String getEmail() {
        return email;
    }
}
