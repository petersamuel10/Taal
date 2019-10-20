package com.vavisa.taal.ui.main.requests.list;


import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Case;
import com.vavisa.taal.data.model.DescriptionField;
import com.vavisa.taal.data.model.Quotation;
import com.vavisa.taal.data.model.Review;
import com.vavisa.taal.ui.main.requests.details.QuotationsAdapter;
import com.vavisa.taal.ui.main.requests.review.ReviewsAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BindingAdapters {

    @BindingAdapter("tabSelectedListener")
    public static void setOnTabSelectedListener(TabLayout tabLayout, TabLayout.OnTabSelectedListener tabSelectedListener) {
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
    }

    @BindingAdapter("setRequestList")
    public static void setRequestList(RecyclerView recyclerView, List<Case> cases) {
        if (cases == null)
            return;

        MyRequestsAdapter requestsAdapter = new MyRequestsAdapter(cases);
        recyclerView.setAdapter(requestsAdapter);
    }

    @BindingAdapter("setQuotationList")
    public static void setQuotationList(RecyclerView recyclerView, List<Quotation> quotations) {
        if (quotations == null)
            return;

        QuotationsAdapter requestsAdapter = new QuotationsAdapter(quotations);
        recyclerView.setAdapter(requestsAdapter);
    }

    @BindingAdapter("setReviewList")
    public static void setReviewList(RecyclerView recyclerView, List<Review> reviews) {
        if (reviews == null)
            return;

        ReviewsAdapter reviewsAdapter = new ReviewsAdapter(reviews);
        recyclerView.setAdapter(reviewsAdapter);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(CircleImageView imageView, String imageUrl) {
        Picasso.get().load(imageUrl).placeholder(R.drawable.image_placholder).into(imageView);
    }

}
