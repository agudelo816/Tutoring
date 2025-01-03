package com.spotter.tutoring.ui.booking;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.spotter.tutoring.R;

public class BookingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        String tutorName = getIntent().getStringExtra("tutorName");

        TextView bookingInfo = findViewById(R.id.bookingInfo);
        bookingInfo.setText("Booking session with " + tutorName);
    }
}
