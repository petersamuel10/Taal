package com.vavisa.taal.ui.main.home.categories;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentHomeBinding;

import java.util.List;
import java.util.Objects;

public class HomeFragment extends BaseFragment {

    protected HomeViewModel viewModel;
    private FragmentHomeBinding homeBinding;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity(), providerFactory).get(HomeViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeCategoryResponse);
        viewModel.getSearchLiveData().observe(this, this::bindCategories);
        homeBinding.setHandler(new SearchEventHandler(viewModel));
        viewModel.getCategories();
    }

    private void consumeCategoryResponse(Resource<List<Category>> listResource) {
        switch (listResource.status) {
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(listResource.error);
                break;

            case SUCCESS:
                hideProgress();
                bindCategories(Objects.requireNonNull(listResource.data));
                break;
        }
    }

    private void bindCategories(List<Category> data) {
        homeBinding.setCategories(data);
    }

}
