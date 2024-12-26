package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;

public class SearchBarFragment extends Fragment {

    private EditText etSearchQuery;
    private RecyclerView rvFilterTabs, rvSortTabs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_bar, container, false);

        etSearchQuery = view.findViewById(R.id.et_search_query);
        rvFilterTabs = view.findViewById(R.id.rv_filter_tabs);
        rvSortTabs = view.findViewById(R.id.rv_sort_tabs);

        // Additional setup for filter and sort tabs can go here

        return view;
    }
}