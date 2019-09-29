package com.vavisa.taal.ui.main.home;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;

public class SearchViewBindingAdapter {

    @BindingAdapter(value = {"onQueryTextSubmit", "onQueryTextChange"}, requireAll = false)
    public static void setQueryListener(SearchView searchView,
                                 androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit onQueryTextSubmit,
                                 androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange onQueryTextChange) {

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