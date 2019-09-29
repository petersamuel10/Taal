package com.vavisa.taal.ui.main;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationViewBindingAdapter {

    @BindingAdapter("selectedItem")
    public static void setSelectedItem(
            BottomNavigationView view, int itemId) {
        view.setSelectedItemId(itemId);
    }

    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(
            BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }
}
