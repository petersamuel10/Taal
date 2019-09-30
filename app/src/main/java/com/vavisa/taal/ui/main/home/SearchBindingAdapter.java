package com.vavisa.taal.ui.main.home;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.adapters.SearchViewBindingAdapter;

public class SearchBindingAdapter {

    @BindingAdapter(value = {"onQueryTextSubmit", "onQueryTextChange"}, requireAll = false)
    public static void setQueryListener(SearchView searchView,
                                 SearchViewBindingAdapter.OnQueryTextSubmit onQueryTextSubmit,
                                 SearchViewBindingAdapter.OnQueryTextChange onQueryTextChange) {

        if (onQueryTextChange == null && onQueryTextSubmit == null) {
            searchView.setOnQueryTextListener(null);
            return;
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return onQueryTextSubmit != null && onQueryTextSubmit.onQueryTextSubmit(query);
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return onQueryTextChange != null && onQueryTextChange.onQueryTextChange(newText);
            }
        });

    }

    @BindingAdapter("onClose")
    public static void setOnCloseListener(SearchView view, SearchView.OnCloseListener listener) {
        view.setOnCloseListener(listener);
    }
}