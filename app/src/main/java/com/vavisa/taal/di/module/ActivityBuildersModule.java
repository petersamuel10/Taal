package com.vavisa.taal.di.module;

import com.vavisa.taal.SplashActivity;
import com.vavisa.taal.di.scope.AuthScope;
import com.vavisa.taal.di.scope.MainScope;
import com.vavisa.taal.ui.auth.base.AuthActivity;
import com.vavisa.taal.ui.auth.login.LoginActivity;
import com.vavisa.taal.ui.auth.register.RegisterActivity;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector()
    abstract SplashActivity contributeSplashActivity();

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class, AuthModule.class})
    abstract LoginActivity contributeLoginActivity();

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class, AuthModule.class})
    abstract RegisterActivity contributeRegisterActivity();

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class, MainViewModelModule.class, MainModule.class})
    abstract NavigationActivity contributeMainActivity();

}
