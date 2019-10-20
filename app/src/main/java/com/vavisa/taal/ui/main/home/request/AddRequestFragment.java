package com.vavisa.taal.ui.main.home.request;

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
import com.vavisa.taal.data.model.GeneralResponse;
import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.helper.dialogs.SuccessDialog;
import com.vavisa.taal.helper.dynamicViews.DynamicView;
import com.vavisa.taal.helper.dynamicViews.DynamicViewFactory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AddRequestFragment extends BaseFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    private AddRequestViewModel viewModel;
    private FragmentAddRequestBinding binding;

    public AddRequestFragment() {
    }

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

        navigationActivity.sharedViewModel.getSelectedCategory()
                .observe(this, category ->
                        viewModel.getRequestParameters(category.getId()));
    }

    private void consumeRequestResponse(Resource<GeneralResponse> caseResponseResource) {
        switch (caseResponseResource.status) {
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(caseResponseResource.error);
                break;

            case SUCCESS:
                hideProgress();
                if (caseResponseResource.data != null) {
                    showSuccessDialog(caseResponseResource.data.getMessage());
                }
                break;
        }
    }

    private void showSuccessDialog(String message) {
        SuccessDialog dialog = new SuccessDialog(navigationActivity,
                android.R.style.Theme_Black_NoTitleBar_Fullscreen,
                () -> navigationActivity.mainBinding.setSelectedItemId(R.id.requests));
        dialog.setMessage(message);
        dialog.show();
    }

    private void createRequestView(List<Parameter> parameters, FragmentAddRequestBinding binding) {
        DynamicViewFactory viewFactory = new DynamicViewFactory(getActivity());
        ArrayList<DynamicView> viewsList = new ArrayList<>();
        for (Parameter parameter : parameters) {
            viewsList.add(viewFactory.createView(parameter));
            viewsList.size();
        }
        binding.setViewsList(viewsList);
    }

    private void consumeResponse(Resource<List<Parameter>> listResource) {
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
                if (listResource.data != null)
                    createRequestView(listResource.data, binding);
                break;
        }
    }
}
