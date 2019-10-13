package com.vavisa.taal.ui.main.requests;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Case;

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

    @BindingAdapter("imageUrl")
    public static void setImageUrl(CircleImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).placeholder(R.drawable.image_placholder).into(imageView);
    }
}
