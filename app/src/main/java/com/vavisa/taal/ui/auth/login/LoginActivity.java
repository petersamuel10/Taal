package com.vavisa.taal.ui.auth.login;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.databinding.ActivityLoginBinding;
import com.vavisa.taal.ui.auth.base.AuthActivity;

public class LoginActivity extends AuthActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel loginViewModel = ViewModelProviders.of(this, providerFactory).get(LoginViewModel.class);
        loginViewModel.observeAuthState().observe(this, this::consumeResponse);
        loginBinding.setViewModel(loginViewModel);
        loginBinding.setEventHandler(new LoginEventHandler(this));
        loginBinding.setLifecycleOwner(this);
    }

}
