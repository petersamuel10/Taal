package com.vavisa.taal.ui.main.requests;

import androidx.databinding.BindingAdapter;

import com.google.android.material.tabs.TabLayout;

public class BindingAdapters {

    @BindingAdapter("tabSelectedListener")
    public static void setOnTabSelectedListener(TabLayout tabLayout, TabLayout.OnTabSelectedListener tabSelectedListener) {
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
    }
}
