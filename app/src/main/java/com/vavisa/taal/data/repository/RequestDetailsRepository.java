package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.RequestDetails;
import com.vavisa.taal.data.network.main.MainApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RequestDetailsRepository {
    private MainApi mainApi;

    @Inject
    RequestDetailsRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<RequestDetails> getRequestDetails(Integer caseId){
        return mainApi.getCaseDetails(caseId);
    }
}
