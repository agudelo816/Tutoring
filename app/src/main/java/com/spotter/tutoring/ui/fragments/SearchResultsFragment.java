package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
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
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        rvSearchResults = view.findViewById(R.id.rv_search_results);

        // Retrieve tutor list and query passed from the activity
        if (getArguments() != null) {
            tutorList = getArguments().getParcelableArrayList("tutorList");
            String query = getArguments().getString("searchQuery", "");
            updateSearchResults(query);
        }

        tutorAdapter = new TutorAdapter(tutorList, tutor -> {
            // Handle tutor click (e.g., show details or navigate to another activity)
        });

        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSearchResults.setAdapter(tutorAdapter);

        return view;
    }

    public void updateSearchResults(String query) {
        List<Tutor> filteredList = new ArrayList<>();
        for (Tutor tutor : tutorList) {
            if (tutor.getName().toLowerCase().contains(query.toLowerCase()) ||
                    tutor.getSubject().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(tutor);
            }
        }
        tutorAdapter.updateList(filteredList);
    }
}
