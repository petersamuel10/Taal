package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.GeneralResponse;
import com.vavisa.taal.data.network.main.MainApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class InvoiceRepository {

    private MainApi mainApi;

    @Inject
    InvoiceRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<GeneralResponse> acceptQuotation(Integer caseId, Integer providerId, Integer quotationId, Integer addressId) {
        return mainApi.acceptQuotation(caseId, providerId, quotationId, addressId);
    }
}

