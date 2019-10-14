package com.vavisa.taal.ui.main.requests.review;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vavisa.taal.R;
import com.vavisa.taal.data.model.Review;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.databinding.FragmentReviewsBottomBinding;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.ui.main.requests.details.RequestDetailsViewModel;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.ProgressDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class ReviewsBottomFragment extends BottomSheetDialogFragment implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Inject
    protected ViewModelProviderFactory providerFactory;

    private FragmentReviewsBottomBinding reviewsBottomBinding;

    public ReviewsBottomFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        reviewsBottomBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reviews_bottom, container, false);
        return reviewsBottomBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ReviewsViewModel viewModel = ViewModelProviders.of(this, providerFactory).get(ReviewsViewModel.class);
        viewModel.getLiveData().observe(this, this::consumeResponse);
        RequestDetailsViewModel requestDetailsViewModel = ViewModelProviders.of(getActivity()).get(RequestDetailsViewModel.class);
        requestDetailsViewModel.getProviderIdLiveData().observe(this, viewModel::getProviderReviews);
    }

    @Override
    public void onAttach(@NotNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    private void consumeResponse(Resource<List<Review>> listResource) {
        switch (listResource.status){
            case LOADING:
                showProgress();
                break;

            case ERROR:
                hideProgress();
                showErrorMessage(listResource.error);
                break;

            case SUCCESS:
                hideProgress();
                reviewsBottomBinding.setReviewList(listResource.data);
        }
    }


    private void showProgress() {
        ProgressDialog.getInstance().show(getActivity());
    }

    private void hideProgress() {
        ProgressDialog.getInstance().dismiss();
    }

    private void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void showErrorMessage(Throwable error) {
        if (error instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) error).response().errorBody();
            showMessage(JsonParser.getErrorMessage(responseBody));
        } else
            showMessage(error.getMessage());
    }

}
