package com.vavisa.taal.ui.main.requests;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.Case;
import com.vavisa.taal.data.model.Status;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.MyRequestsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MyRequestsViewModel extends ViewModel {

    private List<Case> caseList;
    private MyRequestsRepository requestsRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Case>>> liveData = new MutableLiveData<>();

    @Inject
    MyRequestsViewModel(MyRequestsRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }

    MutableLiveData<Resource<List<Case>>> getLiveData() {
        return liveData;
    }

    void getPendingCases() {
        compositeDisposable.add(requestsRepository.getCases()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        cases -> {
                            caseList = cases;
                            filterCaseStatus(Status.PENDING);
                        },
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    void filterCaseStatus(Status status) {
        List<Case> filteredList = new ArrayList<>();
        for (Case aCase : caseList) {
            if (aCase.getStatus().equals(status))
                filteredList.add(aCase);
        }
        liveData.setValue(Resource.success(filteredList));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
