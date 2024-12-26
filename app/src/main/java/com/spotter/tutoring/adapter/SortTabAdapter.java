package com.spotter.tutoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;
import java.util.List;

public class SortTabAdapter extends RecyclerView.Adapter<SortTabAdapter.SortTabViewHolder> {

    private final List<String> sortOptions;

    public SortTabAdapter(List<String> sortOptions) {
        this.sortOptions = sortOptions;
    }

    @NonNull
    @Override
    public SortTabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort_tab, parent, false);
        return new SortTabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SortTabViewHolder holder, int position) {
        holder.tvSortOption.setText(sortOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return sortOptions.size();
    }

    static class SortTabViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvSortOption;

        public SortTabViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvSortOption = itemView.findViewById(R.id.tv_sort_option);

            tvSortOption = itemView.findViewById(R.id.sortText);

        }
    }
}