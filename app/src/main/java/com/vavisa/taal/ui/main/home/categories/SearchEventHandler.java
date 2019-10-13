package com.vavisa.taal.ui.main.home.categories;

public class SearchEventHandler {

    private HomeViewModel viewModel;

    SearchEventHandler(HomeViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public boolean onQueryTextSubmit(String query) {
        viewModel.searchCategories(query);
        return false;
    }

    public boolean onClose() {
        viewModel.resetCategories();
        return false;
    }

}
