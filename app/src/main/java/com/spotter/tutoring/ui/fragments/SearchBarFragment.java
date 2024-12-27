package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.spotter.tutoring.R;
import com.spotter.tutoring.ui.tutor.SearchTutorsActivity;

public class SearchBarFragment extends Fragment {

    private EditText etSearchQuery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_bar, container, false);

        etSearchQuery = view.findViewById(R.id.et_search_query);

        etSearchQuery.setOnEditorActionListener((v, actionId, event) -> {
            String query = v.getText().toString().trim();
            if (!query.isEmpty()) {
                // Notify the activity with the query
                ((SearchTutorsActivity) getActivity()).onSearchQueryEntered(query);
            }
            return true;
        });

        return view;
    }
}
