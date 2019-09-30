package com.vavisa.taal.ui.auth.register;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.vavisa.taal.R;
import com.vavisa.taal.databinding.ActivityRegisterBinding;
import com.vavisa.taal.ui.auth.base.AuthActivity;

public class RegisterActivity extends AuthActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        RegisterViewModel registerViewModel = ViewModelProviders.of(this, providerFactory).get(RegisterViewModel.class);
        registerViewModel.observeAuthState().observe(this, this::consumeResponse);
        registerBinding.setViewModel(registerViewModel);
        registerBinding.setLifecycleOwner(this);
    }
}
