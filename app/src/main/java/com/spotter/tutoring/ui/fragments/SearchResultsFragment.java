package com.spotter.tutoring.ui.fragments;

//import android.os.Bundle;
//import android.os.Parcelable;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import com.spotter.tutoring.R;
//import com.spotter.tutoring.adapter.TutorAdapter;
//import com.spotter.tutoring.model.Tutor;
//
//import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
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

import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class SearchResultsFragment extends Fragment {

    private RecyclerView rvSearchResults;
    private TutorAdapter tutorAdapter;
    private List<Tutor> tutorList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("SearchResultsFragment", "used"); // Add a log to check if the listener is triggered

        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        rvSearchResults = view.findViewById(R.id.rv_search_results);

        // Retrieve tutor list passed from the activity
        if (getArguments() != null) {
//            tutorList = getArguments().getParcelableArrayList("tutorList");
            tutorList = getArguments().getParcelableArrayList("tutorList", Tutor.class);

        }

        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
            // Handle tutor click (e.g., show details or navigate to another activity)
        });

        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSearchResults.setAdapter(tutorAdapter);

        // Set up the search bar
        EditText etSearchQuery = view.findViewById(R.id.et_search_query);
        // Set a listener to detect "Enter" key press
        etSearchQuery.setOnEditorActionListener((v, actionId, event) -> {
            Log.d("SearchResultsFragment", "Editor action triggered: " + actionId); // Add a log to check if the listener is triggered

            // Check if the action is "Enter" and the query is not empty
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH) {
                String query = v.getText().toString().trim();
                if (!query.isEmpty()) {
                    updateSearchResults(query); // Update search results if query is non-empty
                }

                // Hide the keyboard after the action
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                return true; // Indicate that the action was handled
            }
            return false; // Return false if the action was not handled
        });
       /* etSearchQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Call the method to filter the results based on the query
                String query = charSequence.toString();
                updateSearchResults(query);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No action needed here
            }
        });*/

        return view;
    }

    // Method to update the search results based on the query
    public void updateSearchResults(String query) {
        if (tutorList != null) {
            List<Tutor> filteredList = new ArrayList<>();
            for (Tutor tutor : tutorList) {
                // Check if the tutor's name or subject contains the search query
                if (tutor.getName().toLowerCase().contains(query.toLowerCase()) ||
                        tutor.getSubject().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(tutor);
                }
            }
            // Update the adapter with the filtered list
            tutorAdapter.updateList(filteredList);
        }
    }

}