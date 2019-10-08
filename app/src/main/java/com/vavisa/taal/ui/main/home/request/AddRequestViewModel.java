package com.vavisa.taal.ui.main.home.request;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.RequestRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddRequestViewModel extends ViewModel {

    private RequestRepository requestRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Parameter>>> liveData = new MutableLiveData<>();

    @Inject
    AddRequestViewModel(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    MutableLiveData<Resource<List<Parameter>>> getLiveData() {
        return liveData;
    }


    void getRequestParameters() {
        compositeDisposable.add(requestRepository.getCategoryParameters(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        parameters -> liveData.setValue(Resource.success(parameters)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
