package com.spotter.tutoring.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spotter.tutoring.R;
import com.spotter.tutoring.model.Tutor;

import java.util.ArrayList;
import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private List<Tutor> tutorList = new ArrayList<>();  // Initialize with an empty list
    private OnTutorClickListener onTutorClickListener;

    public TutorAdapter(List<Tutor> tutorList, OnTutorClickListener onTutorClickListener) {
        if (tutorList != null) {
            this.tutorList = tutorList;
        }
        this.onTutorClickListener = onTutorClickListener;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        try {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
            return new TutorViewHolder(view);
        } catch (Exception e){
            Log.e("RecyclerView", "Error inflating item layout", e);
            return null;  // Or return a default ViewHolder if necessary

        }
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {

        try{
        if (holder != null && tutorList != null && position < tutorList.size()) {
            Tutor tutor = tutorList.get(position);
            Log.d("TutorAdapter", "Binding tutor: " + tutor.getName());
            holder.nameTextView.setText(tutor.getName());
            holder.subjectTextView.setText(tutor.getSubject());
            holder.ratingTextView.setText(String.valueOf(tutor.getRating()));
            holder.itemView.setOnClickListener(v -> onTutorClickListener.onTutorClick(tutor));
            holder.bind(tutor);  // Call the bind method here

        } else {
            Log.e("TutorAdapter", "Tutor list is null or position is out of bounds.");
        }}
        catch (Exception e) {
            Log.e("MyAdapter", "Error binding ViewHolder", e);
        }

    }

    @Override
    public int getItemCount() {
        return tutorList != null ? tutorList.size() : 0;
    }

    // Method to update the list dynamically
    public void updateList(List<Tutor> newList) {
        if (newList != null) {
            tutorList.clear();
            tutorList.addAll(newList);
            notifyDataSetChanged();

        } else {
            Log.e("TutorAdapter", "New list is null, not updating.");
        }
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView, subjectTextView, ratingTextView;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            try {

                nameTextView = itemView.findViewById(R.id.nameTextView);
                subjectTextView = itemView.findViewById(R.id.subjectTextView);
                ratingTextView = itemView.findViewById(R.id.ratingTextView);

                Log.d("TutorViewHolder", "nameTextView: " + nameTextView);
                Log.d("TutorViewHolder", "subjectTextView: " + subjectTextView);
                Log.d("TutorViewHolder", "ratingTextView: " + ratingTextView);
            }
            catch (Exception e) {
                Log.e("ViewHolder", "Error binding tutor data", e);
            }
        }


        public void bind(Tutor tutor) {
            try {
                if (tutor != null) {
                    nameTextView.setText(tutor.getName());
                    subjectTextView.setText(tutor.getSubject());
//                    ratingTextView.setText(tutor.getRating());
                }
            } catch (Exception e) {
                Log.e("TutorViewHolder", "Error binding tutor data", e);
            }
        }


    }

    public interface OnTutorClickListener {
        void onTutorClick(Tutor tutor);
    }
}
