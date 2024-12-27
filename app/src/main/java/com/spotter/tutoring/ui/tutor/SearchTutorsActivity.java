package com.spotter.tutoring.ui.tutor;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;
import com.spotter.tutoring.adapter.TutorAdapter;
import com.spotter.tutoring.model.Tutor;
import com.spotter.tutoring.ui.fragments.SearchResultsFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchTutorsActivity extends AppCompatActivity {

    private RecyclerView rvTutors;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tutors);

        rvTutors = findViewById(R.id.rv_search_results);
        tutorList = new ArrayList<>();
        loadDummyData();

        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
            // Handle tutor click (e.g., show details or navigate to another activity)
        });
        rvTutors.setLayoutManager(new LinearLayoutManager(this));
        rvTutors.setAdapter(tutorAdapter);


        SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("tutorList", (ArrayList<? extends Parcelable>) tutorList);
        searchResultsFragment.setArguments(bundle);

        // Start fragment transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, searchResultsFragment)
                .commit();
    }

    private void loadDummyData() {
        tutorList.add(new Tutor("Abc Def", "Math", 4.5, "abc@email.com"));
        tutorList.add(new Tutor("John Doe", "Math", 4.5));
        tutorList.add(new Tutor("Jane Smith", "English", 4.7));
        tutorList.add(new Tutor("Mike Johnson", "Science", 3.8));
        tutorList.add(new Tutor("Emily Davis", "History", 4.2));
        tutorList.add(new Tutor("Chris Lee", "Math", 4.9));
    }
}
