package com.vavisa.taal.di.module;

import androidx.lifecycle.ViewModel;

import com.vavisa.taal.di.util.ViewModelKey;
import com.vavisa.taal.ui.auth.login.LoginViewModel;
import com.vavisa.taal.ui.auth.register.RegisterViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    public abstract ViewModel bindRegisterViewModel(RegisterViewModel registerViewModel);
}
