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
import com.spotter.tutoring.utils.TutorData;

import java.util.List;

public class TutorSearchResultsAdapter extends RecyclerView.Adapter<TutorSearchResultsAdapter.TutorViewHolder> {

    private List<Tutor> visibleTutors;
    private OnTutorClickListener onTutorClickListener;

    public TutorSearchResultsAdapter(List<Tutor> tutors, OnTutorClickListener onTutorClickListener) {

        this.visibleTutors = tutors;
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
        if (holder != null && visibleTutors != null && position < visibleTutors.size()) {
            Tutor tutor = visibleTutors.get(position);
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
        return visibleTutors != null ? visibleTutors.size() : 0;
    }

    // Method to update the list dynamically
    public void updateList(final List<Tutor> tutors) {
        if (tutors != null) {
            visibleTutors.clear();
            visibleTutors.addAll(tutors);
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
