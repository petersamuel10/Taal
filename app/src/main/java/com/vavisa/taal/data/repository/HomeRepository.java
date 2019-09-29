package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.network.main.MainApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomeRepository {

    private MainApi mainApi;

    @Inject
    HomeRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<List<Category>> getCategories(){
        return mainApi.getCategories();
    }

}
