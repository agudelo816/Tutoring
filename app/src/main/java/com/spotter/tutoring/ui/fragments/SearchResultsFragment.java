package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spotter.tutoring.R;
import com.spotter.tutoring.adapter.TutorSearchResultsAdapter;
import com.spotter.tutoring.model.Tutor;
import com.spotter.tutoring.utils.TutorData;
import com.spotter.tutoring.utils.TutorSearchResultsUtil;

import java.util.List;

public class SearchResultsFragment extends Fragment {

    private RecyclerView rvSearchResults;
    private TutorSearchResultsAdapter tutorAdapter;

    public SearchResultsFragment() {

        tutorAdapter = new TutorSearchResultsAdapter(TutorData.getTutors(), tutor -> {

        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        rvSearchResults = view.findViewById(R.id.rv_search_results);
        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));

        rvSearchResults.setAdapter(tutorAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            Log.d("SearchResultsFragment", "onViewCreated: Views initialized.");
        } catch (Exception e) {
            Log.e("SearchResultsFragment", "Error in onViewCreated", e);
        }
    }


    // Method to
    // update search results based on query
    public void updateSearchResults(String query) {
        // Filter the tutor list based on the query
        final List<Tutor> filteredList = TutorSearchResultsUtil.filterTutors(TutorData.getTutors(), query);

        // Update the adapter with the filtered list
        tutorAdapter.updateList(filteredList);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("SearchResultsFragment", "onDestroyView called");
    }


}
