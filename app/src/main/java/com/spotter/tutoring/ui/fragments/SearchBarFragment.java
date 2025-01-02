package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.spotter.tutoring.R;
import com.spotter.tutoring.ui.tutor.SearchTutorsActivity;
import android.view.KeyEvent;

public class SearchBarFragment extends Fragment {

    private EditText etSearchQuery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = null;
        try {
            view = inflater.inflate(R.layout.fragment_search_bar, container, false);

            etSearchQuery = view.findViewById(R.id.et_search_query);

            // Set up a listener for the search input
            etSearchQuery.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_SEARCH  && event.getAction() == KeyEvent.ACTION_DOWN) {
                    String query = v.getText().toString().trim();

                        // Trigger the search in the activity
                        if (getActivity() instanceof SearchTutorsActivity) {
                            ((SearchTutorsActivity) getActivity()).onSearchQueryEntered(query);
                        }

                    return true; // Consume the event
                }
                return false;
            });
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception to understand what went wrong
            if (getActivity() != null) {
                // You can use a more robust logging mechanism or a UI alert if needed
                Log.e("SearchBarFragment", "Error in onCreateView", e);
            }
        }

        return view;
    }
}

