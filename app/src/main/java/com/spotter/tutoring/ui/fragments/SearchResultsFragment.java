package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;
import com.spotter.tutoring.adapter.TutorAdapter;
import com.spotter.tutoring.model.Tutor;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsFragment extends Fragment {

    private RecyclerView rvSearchResults;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutorList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_search_results, container, false);
//
//        // Debugging: Confirm the layout file is inflated
//        Log.d("SearchResultsFragment", "View inflated successfully");
//
//        rvSearchResults = view.findViewById(R.id.rv_search_results);
//
//        // Debugging: Confirm RecyclerView initialization
//        if (rvSearchResults != null) {
//            Log.d("SearchResultsFragment", "RecyclerView found: " + rvSearchResults);
//        } else {
//            Log.e("SearchResultsFragment", "RecyclerView not found!");
//        }
//
//        // Retrieve tutor list and query passed from the activity
//        try {
//        if (getArguments() != null) {
//            tutorList = getArguments().getParcelableArrayList("tutorList");
//            if (tutorList == null) {
//                tutorList = new ArrayList<>(); // Initialize with an empty list
//            }
//            String query = getArguments().getString("searchQuery", "");
//            Log.d("SearchResultsFragment", "Tutor list size: " + tutorList.size());
//
//            tutorAdapter = new TutorAdapter(tutorList, tutor -> {
//                // Handle tutor click (e.g., show details or navigate to another activity)
//            });
//
//
//            rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));
//            rvSearchResults.setAdapter(tutorAdapter);
//            rvSearchResults.setRecycledViewPool(new RecyclerView.RecycledViewPool());
//
//
//            updateSearchResults(query);
//        }
//
//        } catch (Exception e) {
//            Log.e("Fragment", "Error setting up RecyclerView", e);
//        }
//
//
//
//        return view;

        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        rvSearchResults = view.findViewById(R.id.rv_search_results);
        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));

        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
            // Handle tutor click (e.g., show details or navigate to another activity)
        });
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

//    private void updateSearchResults(String query) {
//
//        Log.d("SearchResultsFragment", "tutorList: " + tutorList);
//        Log.d("SearchResultsFragment", "query: " + query);
//        if (tutorList != null) {
//            List<Tutor> filteredList = new ArrayList<>();
//            for (Tutor tutor : tutorList) {
//                if (tutor.getName().toLowerCase().contains(query.toLowerCase())) {
//                    filteredList.add(tutor);
//                }
//            }
//
//            // Make sure the adapter is initialized before calling updateList
//            if (tutorAdapter != null) {
//                tutorAdapter.updateList(filteredList);
//            }
//
//
////            toggleEmptyState(filteredList.isEmpty());
//
//        }
//
//
//    }



    // Method to update search results based on query
    public void updateSearchResults(String query) {
        // Filter the tutor list based on the query
        List<Tutor> filteredList = filterTutors(query);

        // Update the adapter with the filtered list
        tutorAdapter.updateList(filteredList);
    }

    public void updateResults(List<Tutor> filteredList) {
        if (tutorList != null) {
            tutorList.clear();  // Clear the existing list
            tutorList.addAll(filteredList);  // Add the new filtered list
            tutorAdapter.notifyDataSetChanged();  // Notify the adapter to refresh the RecyclerView
        }
    }

    private void toggleEmptyState(boolean show) {
        View emptyStateView = getView().findViewById(R.id.empty_state_view);
        if (emptyStateView != null) {
            emptyStateView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
        rvSearchResults.setVisibility(show ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("SearchResultsFragment", "onDestroyView called");
    }


    private List<Tutor> filterTutors(String query) {
        List<Tutor> filteredList = new ArrayList<>();
        // Sample tutor data, replace with actual data source
        tutorList.add(new Tutor("Abc Def", "Math", 4.5, "abc@email.com"));
        tutorList.add(new Tutor("John Doe", "Math", 4.5));

        for (Tutor tutor : tutorList) {
            if (tutor.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(tutor);
            }
        }

        return filteredList;
    }
}
