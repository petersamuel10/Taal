package com.vavisa.taal.base;

import android.widget.Toast;

import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.ProgressDialog;


import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class BaseFragment extends DaggerFragment {

    @Inject
    protected ViewModelProviderFactory providerFactory;

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
