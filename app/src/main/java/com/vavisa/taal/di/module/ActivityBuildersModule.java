package com.vavisa.taal.di.module;

import com.vavisa.taal.di.scope.AuthScope;
import com.vavisa.taal.di.scope.MainScope;
import com.vavisa.taal.ui.auth.LoginActivity;
import com.vavisa.taal.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class, AuthModule.class})
    abstract LoginActivity contributeLoginActivity();

    @MainScope
    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class, MainViewModelModule.class, MainModule.class})
    abstract MainActivity contributeMainActivity();

}
