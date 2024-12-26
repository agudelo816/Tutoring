package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;

public class SearchResultsFragment extends Fragment {

    private RecyclerView rvSearchResults;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        rvSearchResults = view.findViewById(R.id.rv_search_results);

        // Setup adapter and data binding for the search results list

        return view;
    }
}