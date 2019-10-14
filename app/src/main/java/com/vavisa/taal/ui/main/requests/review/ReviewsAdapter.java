package com.vavisa.taal.ui.main.requests.review;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Review;
import com.vavisa.taal.databinding.ReviewItemBinding;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {

    private List<Review> reviews;

    public ReviewsAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReviewItemBinding reviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.review_item, parent, false);
        return new ViewHolder(reviewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.reviewItemBinding.setReview(reviews.get(position));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ReviewItemBinding reviewItemBinding;

        ViewHolder(@NonNull ReviewItemBinding reviewItemBinding) {
            super(reviewItemBinding.getRoot());
            this.reviewItemBinding = reviewItemBinding;
        }
    }
}
