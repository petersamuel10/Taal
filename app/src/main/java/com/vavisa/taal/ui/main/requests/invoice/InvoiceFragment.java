package com.vavisa.taal.ui.main.requests.invoice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.GeneralResponse;
import com.vavisa.taal.data.network.main.Resource;

public class InvoiceFragment extends BaseFragment {

    public InvoiceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_invoive, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        InvoiceViewModel viewModel = ViewModelProviders.of(this, providerFactory).get(InvoiceViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        sharedViewModel.getRequestInvoice().observe(this, invoice ->
                viewModel.acceptQuotation(invoice.getRequestCase().getCaseId(),
                invoice.getQuotation().getProvider().getProviderId(),
                invoice.getQuotation().getId(),
                invoice.getAddress().getId()));
    }

    private void consumeResponse(Resource<GeneralResponse> generalResponseResource) {

    }
}
