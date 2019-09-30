package com.vavisa.taal.di.module;


import androidx.lifecycle.ViewModel;

import com.vavisa.taal.di.util.ViewModelKey;
import com.vavisa.taal.ui.main.home.HomeViewModel;
import com.vavisa.taal.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    public abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

}
