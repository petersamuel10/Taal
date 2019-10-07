package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.MainApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RequestRepository {
    private MainApi mainApi;

    @Inject
    RequestRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<List<Parameter>> getCategoryParameters(Integer categoryId){
        return mainApi.getCategoryParameters(categoryId);
    }
}
