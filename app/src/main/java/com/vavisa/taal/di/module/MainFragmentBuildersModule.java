package com.vavisa.taal.di.module;


import com.vavisa.taal.ui.main.home.HomeFragment;
import com.vavisa.taal.ui.main.profile.ProfileFragment;
import com.vavisa.taal.ui.main.requests.RequestsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract RequestsFragment contributeRequestsFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();
}
