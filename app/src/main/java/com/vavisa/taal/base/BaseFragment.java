package com.vavisa.taal.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.helper.SharedViewModel;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.ProgressDialog;


import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class BaseFragment extends DaggerFragment {

    @Inject
    protected SessionManager sessionManager;

    @Inject
    protected ViewModelProviderFactory providerFactory;

    protected SharedViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
    }

    public BaseFragment() {}

    protected void showProgress() {
        ProgressDialog.getInstance().show(getActivity());
    }

    protected void hideProgress() {
        ProgressDialog.getInstance().dismiss();
    }

    protected void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showErrorMessage(Throwable error) {
        if (error instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) error).response().errorBody();
            showMessage(JsonParser.getErrorMessage(responseBody));
        } else
            showMessage(error.getMessage());
    }

}
