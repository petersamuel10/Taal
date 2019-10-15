package com.vavisa.taal.ui.main.requests.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Quotation;
import com.vavisa.taal.databinding.QuotationItemBinding;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;
import com.vavisa.taal.ui.main.requests.review.ReviewsBottomFragment;

import java.util.List;

public class QuotationsAdapter extends RecyclerView.Adapter<QuotationsAdapter.ViewHolder> {

    private List<Quotation> quotations;
    private NavigationActivity activity;

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
        holder.quotationItemBinding.setClickListener(view -> {
            ViewModelProviders.of(activity)
                    .get(RequestDetailsViewModel.class)
                    .setProviderIdLiveData(quotations.get(position)
                            .getProvider().getProviderId());
            ReviewsBottomFragment reviewsBottomFragment = new ReviewsBottomFragment();
            reviewsBottomFragment.show(activity.getSupportFragmentManager(), "modalSheetDialog");
        });
    }

    @Override
    public int getItemCount() {
        return quotations.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        activity = (NavigationActivity) recyclerView.getContext();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private QuotationItemBinding quotationItemBinding;

        ViewHolder(@NonNull QuotationItemBinding quotationItemBinding) {
            super(quotationItemBinding.getRoot());
            this.quotationItemBinding = quotationItemBinding;
        }
    }
}
