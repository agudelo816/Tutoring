package com.spotter.tutoring.ui.tutor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.spotter.tutoring.R;
import com.spotter.tutoring.ui.fragments.SearchResultsFragment;
import com.spotter.tutoring.ui.fragments.SearchBarFragment;

public class SearchTutorsActivity extends AppCompatActivity {


    private SearchBarFragment searchBarFragment;
    private SearchResultsFragment searchResultsFragment;

    public SearchTutorsActivity(){

        searchBarFragment = new SearchBarFragment();
        searchResultsFragment = new SearchResultsFragment();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tutors);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_search_bar, searchBarFragment)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_search_results, searchResultsFragment)
                .commit();
    }

    // Method to handle search query entered in SearchBarFragment
    public void onSearchQueryEntered(String query) {

        SearchResultsFragment searchResultsFragment = (SearchResultsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_search_results);

        if (searchResultsFragment != null) {
            searchResultsFragment.updateSearchResults(query);  // Pass the query to update results
        }

        }


}
