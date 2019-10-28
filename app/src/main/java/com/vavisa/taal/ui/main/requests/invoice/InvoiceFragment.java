package com.vavisa.taal.ui.main.requests.invoice;

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
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentInvoiceBinding;

public class InvoiceFragment extends BaseFragment {

    private FragmentInvoiceBinding invoiceBinding;

    public InvoiceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        invoiceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invoice, container, false);
        return invoiceBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        InvoiceViewModel viewModel = ViewModelProviders.of(this, providerFactory).get(InvoiceViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        invoiceBinding.setViewModel(viewModel);
        sharedViewModel.getRequestInvoice().observe(this, invoice -> invoiceBinding.setInvoice(invoice));
    }

    private void consumeResponse(Resource<GeneralResponse> generalResponseResource) {
        switch (generalResponseResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(generalResponseResource.error);
                break;

            case SUCCESS:
                hideProgress();
        }
    }
}
