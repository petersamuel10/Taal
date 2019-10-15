package com.vavisa.taal.ui.main.requests.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Case;
import com.vavisa.taal.databinding.RequestItemLayoutBinding;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;
import com.vavisa.taal.ui.main.requests.details.RequestDetailsFragment;

import java.util.List;

public class MyRequestsAdapter extends RecyclerView.Adapter<MyRequestsAdapter.ViewHolder> {

    private List<Case> caseList;
    private NavigationActivity activity;

    MyRequestsAdapter(List<Case> caseList) {
        this.caseList = caseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RequestItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.request_item_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setRequest(caseList.get(position));
        holder.binding.setClickListener(view -> {
            activity.addFragment(new RequestDetailsFragment());
        });
    }

    @Override
    public int getItemCount() {
        return caseList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        activity = (NavigationActivity) recyclerView.getContext();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RequestItemLayoutBinding binding;

        ViewHolder(@NonNull RequestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
