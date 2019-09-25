package com.vavisa.taal.ui.auth.login;

import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.databinding.ActivityLoginBinding;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.ui.main.MainActivity;
import com.vavisa.taal.util.Preferences;
import com.vavisa.taal.util.ProgressDialog;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Preferences preferences;

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        loginViewModel.observeAuthState().observe(this, this::consumeResponse);
        loginBinding.setViewModel(loginViewModel);
        loginBinding.setEventHandler(new LoginEventHandler(this));
        loginBinding.setLifecycleOwner(this);
    }

    private void consumeResponse(AuthResource<User> userAuthResource) {
        switch (userAuthResource.status) {
            case ERROR:
                ProgressDialog.getInstance().dismiss();
                Toast.makeText(this, userAuthResource.message, Toast.LENGTH_SHORT).show();
                break;

            case LOADING:
                ProgressDialog.getInstance().show(this);
                break;

            case AUTHENTICATED:
                ProgressDialog.getInstance().dismiss();
                start(MainActivity.class);
                break;

            case NOT_AUTHENTICATED:
                ProgressDialog.getInstance().dismiss();
                break;
        }
    }

}
