package com.vavisa.taal.ui.main.requests.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.RequestDetails;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.RequestDetailsRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RequestDetailsViewModel extends ViewModel {

    private RequestDetailsRepository requestDetailsRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<RequestDetails>> liveData = new MutableLiveData<>();

    @Inject
    RequestDetailsViewModel(RequestDetailsRepository requestDetailsRepository) {
        this.requestDetailsRepository = requestDetailsRepository;
    }

    public MutableLiveData<Resource<RequestDetails>> getLiveData() {
        return liveData;
    }

    void getRequestDetails(Integer caseId){
        compositeDisposable.add(requestDetailsRepository.getRequestDetails(caseId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        requestDetails -> liveData.setValue(Resource.success(requestDetails)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));

    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
