package com.spotter.tutoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spotter.tutoring.R;
import com.spotter.tutoring.model.Tutor;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private List<Tutor> tutorList;
    private OnTutorClickListener onTutorClickListener;

    public TutorAdapter(List<Tutor> tutorList, OnTutorClickListener onTutorClickListener) {
        this.tutorList = tutorList;
        this.onTutorClickListener = onTutorClickListener;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutor, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {
        Tutor tutor = tutorList.get(position);
        holder.nameTextView.setText(tutor.getName());
        holder.subjectTextView.setText(tutor.getSubject());
        holder.ratingTextView.setText(String.valueOf(tutor.getRating()));
        holder.itemView.setOnClickListener(v -> onTutorClickListener.onTutorClick(tutor));
    }

    @Override
    public int getItemCount() {
        return tutorList != null ? tutorList.size() : 0;
    }

    // Method to update the list dynamically
    public void updateList(List<Tutor> newList) {
        tutorList = newList;
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, subjectTextView, ratingTextView;

        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
        }
    }

    public interface OnTutorClickListener {
        void onTutorClick(Tutor tutor);
    }
}

