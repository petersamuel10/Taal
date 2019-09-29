package com.vavisa.taal.ui.main.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.HomeRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Category>>> liveData = new MutableLiveData<>();

    @Inject
    public HomeViewModel(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public MutableLiveData<Resource<List<Category>>> getLiveData() {
        return liveData;
    }

    void getCategories() {
        compositeDisposable.add(homeRepository.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        categories -> liveData.setValue(Resource.success(categories)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
