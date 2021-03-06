package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.Review;
import com.vavisa.taal.data.network.main.MainApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ReviewsRepository {

    private MainApi mainApi;

    @Inject
    ReviewsRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<List<Review>> getProviderReviews(Integer providerId) {
        return mainApi.getProviderReviews(providerId);
    }
}
