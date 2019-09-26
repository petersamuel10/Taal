package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.AuthResponse;
import com.vavisa.taal.data.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RegisterRepository {

    private AuthApi authApi;

    @Inject
    RegisterRepository(AuthApi authApi){
        this.authApi = authApi;
    }

    public Flowable<AuthResponse> registerUser(String name, String email, String mobile, String password, String confirmPassword){
        return authApi.userRegister(name, email, mobile, password, confirmPassword);
    }
}
