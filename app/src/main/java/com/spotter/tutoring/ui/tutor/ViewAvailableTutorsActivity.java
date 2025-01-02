package com.spotter.tutoring.ui.tutor;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAvailableTutorsActivity extends AppCompatActivity {
/*
    private RecyclerView tutorRecyclerView;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // Initialize RecyclerView
        tutorRecyclerView = findViewById(R.id.tutorRecyclerView);
        tutorRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize dummy data for tutors
        tutorList = new ArrayList<>();
        tutorList.add(new Tutor("Alice Johnson", "Mathematics", 4.8));
        tutorList.add(new Tutor("Bob Smith", "Physics", 4.6));
        tutorList.add(new Tutor("Charlie Brown", "Chemistry", 4.9));

        // Set up the adapter
        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
            // On tutor click, navigate to a booking screen
            Toast.makeText(this, "Selected: " + tutor.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ViewAvailableTutorsActivity.this, BookingActivity.class);
            intent.putExtra("tutorName", tutor.getName());
            startActivity(intent);
        });
        tutorRecyclerView.setAdapter(tutorAdapter);

        // Set up bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_search:
//                    Toast.makeText(StudentActivity.this, "Search selected", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.nav_sessions:
//                    Toast.makeText(StudentActivity.this, "Sessions selected", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.nav_profile:
//                    Toast.makeText(StudentActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
//                    return true;
//                default:
//                    return false;
//            }
//        });

    }


 */
}
