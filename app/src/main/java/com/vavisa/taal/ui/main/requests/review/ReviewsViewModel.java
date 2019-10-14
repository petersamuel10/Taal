package com.vavisa.taal.ui.main.requests.review;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Review;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.ReviewsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ReviewsViewModel extends ViewModel {

    private ReviewsRepository reviewsRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Review>>> liveData = new MutableLiveData<>();

    public ReviewsViewModel(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    void getProviderReviews(Integer providerId) {
        compositeDisposable.add(reviewsRepository.getProviderReviews(providerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        reviews -> liveData.setValue(Resource.success(reviews)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
