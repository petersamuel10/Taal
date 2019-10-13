package com.vavisa.taal.ui.main.requests;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Case;
import com.vavisa.taal.databinding.RequestItemLayoutBinding;

import java.util.List;

public class MyRequestsAdapter extends RecyclerView.Adapter<MyRequestsAdapter.ViewHolder> {

    private List<Case> caseList;

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
    }

    @Override
    public int getItemCount() {
        return caseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RequestItemLayoutBinding binding;

        ViewHolder(@NonNull RequestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
