package com.vavisa.taal.ui.main.home.request;

import android.view.View;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;

import java.util.ArrayList;

public class RequestBindingAdapter {

    @BindingAdapter("addViews")
    public static void addDynamicView(LinearLayout layout, ArrayList<View> views) {
        for (View view: views) {
            layout.addView(view);
        }
    }
}
