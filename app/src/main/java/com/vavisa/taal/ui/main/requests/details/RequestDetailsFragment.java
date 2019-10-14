package com.vavisa.taal.ui.main.requests.details;

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
import com.vavisa.taal.data.model.RequestDetails;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentRequestDetailsBinding;

public class RequestDetailsFragment extends BaseFragment {

    private FragmentRequestDetailsBinding requestDetailsBinding;

    public RequestDetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_request_details, container, false);
        return requestDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RequestDetailsViewModel viewModel = ViewModelProviders.of(getActivity(), providerFactory).get(RequestDetailsViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        viewModel.getRequestDetails(1);
    }

    private void consumeResponse(Resource<RequestDetails> requestDetailsResource) {
        switch (requestDetailsResource.status) {
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(requestDetailsResource.error);
                break;

            case SUCCESS:
                hideProgress();
                if (requestDetailsResource.data != null) {
                    displayRequestDetails(requestDetailsResource.data);
                }
        }
    }

    private void displayRequestDetails(RequestDetails data) {
        requestDetailsBinding.setRequest(data.getCaseDetails());
        requestDetailsBinding.setQuotationList(data.getQuotations());
    }
}
