package com.spotter.tutoring.ui.tutor;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;
import com.spotter.tutoring.adapter.TutorAdapter;
import com.spotter.tutoring.model.Tutor;
import com.spotter.tutoring.ui.fragments.SearchResultsFragment;
import com.spotter.tutoring.ui.fragments.SearchBarFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchTutorsActivity extends AppCompatActivity {

    private RecyclerView rvTutors;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_tutors);
//
//        rvTutors = findViewById(R.id.rv_search_results);
//        tutorList = new ArrayList<>();
//        loadDummyData();
//
//        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
//            // Handle tutor click (e.g., show details or navigate to another activity)
//        });
//        rvTutors.setLayoutManager(new LinearLayoutManager(this));
//        rvTutors.setAdapter(tutorAdapter);
//
//        // Initialize the SearchBarFragment
//        SearchBarFragment searchBarFragment = new SearchBarFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container_search_bar, searchBarFragment)
//                .commit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tutors);

        // Initialize the SearchBarFragment
        SearchBarFragment searchBarFragment = new SearchBarFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_search_bar, searchBarFragment)
                .commit();

        // Initialize the SearchResultsFragment (empty at first)
        SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_search_results, searchResultsFragment)
                .commit();
    }

    // Method to handle search query entered in SearchBarFragment
    public void onSearchQueryEntered(String query) {
//
//        Log.d("SearchTutorsActivity", "onSearchQueryEntered");
//
//        // Filter the tutor list based on the search query
//        List<Tutor> filteredList = filterTutors(query);
//
//        // Update the adapter with the filtered list
//        tutorAdapter.updateList(filteredList); // Assuming updateList is a method in your adapter
//
//        // Optionally, you can also update the SearchResultsFragment if you want to show results in a different fragment
//        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getSupportFragmentManager()
//                .findFragmentByTag("SEARCH_RESULTS_FRAGMENT");
//
//        if (searchResultsFragment != null) {
//            // If the fragment already exists, update its data
//            searchResultsFragment.updateResults(filteredList);
//        } else {
//            // If the fragment doesn't exist, create a new one and pass the filtered data
//            searchResultsFragment = new SearchResultsFragment();
//            Bundle bundle = new Bundle();
//            bundle.putString("searchQuery", query);
//            bundle.putParcelableArrayList("tutorList", new ArrayList<>(filteredList));
//            searchResultsFragment.setArguments(bundle);
//
//            // Replace or add the fragment to the fragment container
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container_search_bar, searchResultsFragment, "SEARCH_RESULTS_FRAGMENT")
//                    .commit();
//        }

        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_search_results);

        if (searchResultsFragment != null) {
            searchResultsFragment.updateSearchResults(query);  // Pass the query to update results
        }

        }

    private List<Tutor> filterTutors(String query) {
        List<Tutor> filteredList = new ArrayList<>();
        for (Tutor tutor : tutorList) {
            if (tutor.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(tutor);
            }
        }
        return filteredList;
    }

    private void loadDummyData() {
        tutorList.add(new Tutor("Abc Def", "Math", 4.5, "abc@email.com"));
        tutorList.add(new Tutor("John Doe", "Math", 4.5));
//        tutorList.add(new Tutor("Jane Smith", "English", 4.7));
//        tutorList.add(new Tutor("Mike Johnson", "Science", 3.8));
//        tutorList.add(new Tutor("Emily Davis", "History", 4.2));
//        tutorList.add(new Tutor("Chris Lee", "Math", 4.9));
    }
}
