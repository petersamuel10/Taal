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
import com.vavisa.taal.data.model.Address;
import com.vavisa.taal.data.model.Invoice;
import com.vavisa.taal.data.model.Quotation;
import com.vavisa.taal.data.model.RequestDetails;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentRequestDetailsBinding;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;
import com.vavisa.taal.ui.main.profile.addresses.AddressesFragment;
import com.vavisa.taal.ui.main.profile.addresses.AddressesViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RequestDetailsFragment extends BaseFragment {

    private Invoice invoice;

    private FragmentRequestDetailsBinding requestDetailsBinding;

    public RequestDetailsFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_request_details, container, false);
        return requestDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        if (sessionManager != null) {
//            if (sessionManager.getAuthUser().getValue() != null)
//                invoice = new Invoice(sessionManager.getAuthUser().getValue().data);
//            else
//                showMessage("Value Null");
//        } else
//            showMessage("Session Null");
        RequestDetailsViewModel viewModel = ViewModelProviders
                .of(Objects.requireNonNull(getActivity()), providerFactory)
                .get(RequestDetailsViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        viewModel.getAcceptedQuotation().observe(this, this::acceptQuotation);
        viewModel.getRequestDetails(1);
        observeForAddressSelected();
    }

    private void acceptQuotation(Quotation quotation) {
//        invoice.setQuotation(quotation);
        ((NavigationActivity) Objects.requireNonNull(getActivity())).addFragment(new AddressesFragment());
    }

    private void observeForAddressSelected() {
        AddressesViewModel addressesViewModel = ViewModelProviders
                .of(Objects.requireNonNull(getActivity()), providerFactory)
                .get(AddressesViewModel.class);
        addressesViewModel.getSelectedAddress().observe(this, this::openInvoice);
    }

    private void openInvoice(Address address) {
        invoice.setAddress(address);
        ((NavigationActivity) Objects.requireNonNull(getActivity())).addFragment(new AddressesFragment());
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
//        invoice.setRequestCase(data.getCaseDetails());
        requestDetailsBinding.setRequest(data.getCaseDetails());
        requestDetailsBinding.setQuotationList(data.getQuotations());
    }
}
