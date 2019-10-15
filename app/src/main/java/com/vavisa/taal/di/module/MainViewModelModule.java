package com.vavisa.taal.di.module;


import androidx.lifecycle.ViewModel;

import com.vavisa.taal.di.util.ViewModelKey;
import com.vavisa.taal.ui.main.home.categories.HomeViewModel;
import com.vavisa.taal.ui.main.home.request.AddRequestViewModel;
import com.vavisa.taal.ui.main.profile.ProfileViewModel;
import com.vavisa.taal.ui.main.requests.list.MyRequestsViewModel;
import com.vavisa.taal.ui.main.requests.details.RequestDetailsViewModel;
import com.vavisa.taal.ui.main.requests.review.ReviewsViewModel;

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
    @ViewModelKey(AddRequestViewModel.class)
    public abstract ViewModel bindAddRequestViewModel(AddRequestViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MyRequestsViewModel.class)
    public abstract ViewModel bindMyRequestViewModel(MyRequestsViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RequestDetailsViewModel.class)
    public abstract ViewModel bindRequestDetailsViewModel(RequestDetailsViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ReviewsViewModel.class)
    public abstract ViewModel bindReviewsViewModel(ReviewsViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

}
