package com.vavisa.taal.ui.main.requests.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Quotation;
import com.vavisa.taal.databinding.QuotationItemBinding;

import java.util.List;

public class QuotationsAdapter extends RecyclerView.Adapter<QuotationsAdapter.ViewHolder>{

    private List<Quotation> quotations;

    public QuotationsAdapter(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuotationItemBinding quotationItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.quotation_item, parent, false);
        return new ViewHolder(quotationItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quotationItemBinding.setQuotation(quotations.get(position));
    }

    @Override
    public int getItemCount() {
        return quotations.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private QuotationItemBinding quotationItemBinding;

        ViewHolder(@NonNull QuotationItemBinding quotationItemBinding) {
            super(quotationItemBinding.getRoot());
            this.quotationItemBinding = quotationItemBinding;
        }
    }
}
