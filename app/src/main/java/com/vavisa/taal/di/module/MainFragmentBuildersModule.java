package com.vavisa.taal.di.module;


import com.vavisa.taal.ui.main.home.HomeFragment;
import com.vavisa.taal.ui.main.home.request.AddRequestFragment;
import com.vavisa.taal.ui.main.profile.ProfileFragment;
import com.vavisa.taal.ui.main.requests.MyRequestsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract AddRequestFragment contributeAddRequestFragment();

    @ContributesAndroidInjector
    abstract MyRequestsFragment contributeRequestsFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();
}
