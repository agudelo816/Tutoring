package com.spotter.tutoring.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.spotter.tutoring.R;
import com.spotter.tutoring.model.Tutor;

public class TutorItemFragment extends Fragment {

//    private TextView tvTutorName, tvTutorRating;
//    private ImageView ivTutorProfilePicture;

    private static final String ARG_TUTOR = "tutor";

    private Tutor tutor;

    public static TutorItemFragment newInstance(Tutor tutor) {
        TutorItemFragment fragment = new TutorItemFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_TUTOR, tutor);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutor_item, container, false);


        TextView tvTutorName = view.findViewById(R.id.tv_tutor_name);
        TextView tvTutorRating = view.findViewById(R.id.tv_tutor_rating);
        ImageView ivTutorProfilePicture = view.findViewById(R.id.iv_tutor_profile_picture);

        if (tutor != null) {
            tvTutorName.setText(tutor.getName());
            tvTutorRating.setText(String.valueOf(tutor.getRating()));
        }


        return view;
    }


}
