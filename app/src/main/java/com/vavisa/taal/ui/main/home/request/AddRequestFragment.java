package com.vavisa.taal.ui.main.home.request;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.CaseResponse;
import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.ui.main.home.HomeViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class AddRequestFragment extends BaseFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    private AddRequestViewModel viewModel;
    private FragmentAddRequestBinding binding;

    public AddRequestFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_request, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(AddRequestViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        viewModel.getCaseLiveData().observe(this, this::consumeRequestResponse);
        binding.setViewModel(viewModel);
        observeSelectedCategory();
    }

    private void consumeRequestResponse(Resource<CaseResponse> caseResponseResource) {
        switch (caseResponseResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(caseResponseResource.error);
                break;

            case SUCCESS:
                hideProgress();
                break;
        }
    }

    private void observeSelectedCategory() {
        ViewModelProviders.of(Objects.requireNonNull(getActivity()), providerFactory)
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
                if (listResource.data != null)
                    viewModel.createRequestView(listResource.data, binding);
                break;
        }
    }
}
