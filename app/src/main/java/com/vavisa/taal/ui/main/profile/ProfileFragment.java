package com.vavisa.taal.ui.main.profile;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseFragment;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.util.JsonParser;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class ProfileFragment extends BaseFragment {

    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ProfileViewModel viewModel = ViewModelProviders.of(this, providerFactory).get(ProfileViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
//        viewModel.getUserProfile();
    }

    private void consumeResponse(Resource<User> userResource) {
        switch (userResource.status) {
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                if (userResource.error instanceof HttpException) {
                    ResponseBody responseBody = ((HttpException) userResource.error).response().errorBody();
                    showMessage(JsonParser.getErrorMessage(responseBody));
                } else
                    showMessage(userResource.error.getMessage());
                break;

            case SUCCESS:
                hideProgress();
                bindUserDetails();
                break;
        }
    }

    private void bindUserDetails() {
        //TODO bind user details to the view
    }
}
