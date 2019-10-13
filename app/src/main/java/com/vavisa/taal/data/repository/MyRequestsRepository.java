package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.CaseResponse;
import com.vavisa.taal.data.network.main.MainApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MyRequestsRepository {

    private MainApi mainApi;

    @Inject
    MyRequestsRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<List<CaseResponse>> getCases(){
        return mainApi.getCases();
    }
}
