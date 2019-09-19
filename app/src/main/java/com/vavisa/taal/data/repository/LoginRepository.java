package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LoginRepository {
    private AuthApi authApi;

    @Inject
    LoginRepository(AuthApi authApi){
        this.authApi = authApi;
    }

    public Flowable<User> loginUser(String email, String password){
        return authApi.userLogin(email, password);
    }
}
