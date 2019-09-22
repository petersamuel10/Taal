package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.main.MainApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProfileRepository {

    private MainApi mainApi;

    @Inject
    ProfileRepository(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Observable<User> getUserProfile(){
        return mainApi.getUserProfile();
    }

}
