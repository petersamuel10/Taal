package com.vavisa.taal.data.repository;

import android.content.Context;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.AuthResponse;
import com.vavisa.taal.data.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LoginRepository {

    private AuthApi authApi;
    private Context context;

    @Inject
    LoginRepository(AuthApi authApi, Context context){
        this.authApi = authApi;
        this.context = context;
    }

    public Flowable<AuthResponse> loginUser(String email, String password, String playerId){
        return authApi.userLogin(email, password, playerId, context.getResources().getInteger(R.integer.device_type));
    }
}
