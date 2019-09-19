package com.vavisa.taal.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.vavisa.taal.di.util.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}
