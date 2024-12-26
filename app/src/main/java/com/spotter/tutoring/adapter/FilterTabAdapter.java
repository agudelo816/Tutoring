package com.spotter.tutoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.spotter.tutoring.R;
import java.util.List;

public class FilterTabAdapter extends RecyclerView.Adapter<FilterTabAdapter.FilterTabViewHolder> {

    private final List<String> filterOptions;

    public FilterTabAdapter(List<String> filterOptions) {
        this.filterOptions = filterOptions;
    }

    @NonNull
    @Override
    public FilterTabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_tab, parent, false);
        return new FilterTabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterTabViewHolder holder, int position) {
        holder.tvFilterOption.setText(filterOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return filterOptions.size();
    }

    static class FilterTabViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvFilterOption;

        public FilterTabViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvFilterOption = itemView.findViewById(R.id.tv_filter_option);

            tvFilterOption = itemView.findViewById(R.id.filterText);

        }
    }
}
