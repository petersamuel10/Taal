package com.vavisa.taal.ui.main.navigation;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationBindingAdapter {

    @BindingAdapter("selectedItem")
    public static void setSelectedItem(
            BottomNavigationView view, Integer itemId) {
        view.setSelectedItemId(itemId);
    }

    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(
            BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }
}
