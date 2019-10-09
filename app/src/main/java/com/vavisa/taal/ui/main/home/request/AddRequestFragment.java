package com.vavisa.taal.ui.main.home.request;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.CaseField;
import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.ui.main.home.HomeViewModel;
import com.vavisa.taal.util.dynamicViews.DynamicView;
import com.vavisa.taal.util.dynamicViews.DynamicViewFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class AddRequestFragment extends BaseFragment {

    private ArrayList<CaseField> fields;

    @Inject
    ViewModelProviderFactory providerFactory;

    private AddRequestViewModel viewModel;
    private FragmentAddRequestBinding binding;

    public AddRequestFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_request, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(AddRequestViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        observeSelectedCategory();
    }

    private void observeSelectedCategory() {
        ViewModelProviders.of(getActivity(), providerFactory)
                .get(HomeViewModel.class)
                .getSelectedCategory()
                .observe(this, category -> {
                    viewModel.getRequestParameters(category.getId());
                });
    }

    private void consumeResponse(Resource<List<Parameter>> listResource) {
        switch (listResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(listResource.error);
                break;

            case SUCCESS:
                hideProgress();
                createRequestView(Objects.requireNonNull(listResource.data));
                break;
        }
    }

    private void createRequestView(List<Parameter> parameters) {
        DynamicViewFactory viewFactory = new DynamicViewFactory(getActivity());
        ArrayList<DynamicView> viewsList = new ArrayList<>();
        fields = new ArrayList<>();
        for (Parameter parameter: parameters){
            viewsList.add(viewFactory.createView(parameter));
            CaseField field = new CaseField(parameter.getId());
            fields.add(field);
        }
        binding.setViewsList(viewsList);
    }

    private boolean getCaseFields(){

        return true;
    }
}
