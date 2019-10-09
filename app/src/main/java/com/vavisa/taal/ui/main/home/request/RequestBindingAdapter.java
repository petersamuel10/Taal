package com.vavisa.taal.ui.main.home.request;

import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;

import com.vavisa.taal.util.dynamicViews.DynamicView;

import java.util.ArrayList;

public class RequestBindingAdapter {

    @BindingAdapter("addViews")
    public static void addDynamicView(LinearLayout layout, ArrayList<DynamicView> views) {
        if (views == null)
            return;
        for (DynamicView dynamicView: views) {
            layout.addView(dynamicView.getView());
        }
    }
}
