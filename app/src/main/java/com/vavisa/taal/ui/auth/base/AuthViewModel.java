package com.vavisa.taal.ui.auth.base;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.vavisa.taal.data.model.AuthResponse;
import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.util.CodingKeys;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.Preferences;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public abstract class AuthViewModel extends ViewModel {

    protected SessionManager sessionManager;
    public Preferences preferences;
    protected Context context;

    public abstract boolean isValidInput();
    public abstract void authWithCredentials();

    public void onAuthClicked(){
        if (isValidInput())
            authWithCredentials();
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }

    protected LiveData<AuthResource<User>> queryUserCredentials(Flowable<AuthResponse> responseFlowable) {
        return LiveDataReactiveStreams.fromPublisher(responseFlowable
                .onErrorReturn(throwable -> {
                    AuthResponse errorResponse = new AuthResponse();
                    if (throwable instanceof HttpException) {
                        ResponseBody responseBody = ((HttpException) throwable).response().errorBody();
                        errorResponse.setMessage((JsonParser.getMessage(responseBody)));
                    }
                    return errorResponse;
                })
                .map((Function<AuthResponse, AuthResource<User>>) response -> {
                    if (response.getUser() == null) {
                        return AuthResource.error(response.getMessage(), null);
                    }
                    storeUserDetails(response);
                    return AuthResource.authenticated(response.getUser());
                })
                .subscribeOn(Schedulers.io()));
    }

    private void storeUserDetails(AuthResponse response) {
        String userJson = new Gson().toJson(response.getUser());
        preferences.putString(CodingKeys.USER_KEY.getKey(), userJson);
        preferences.putBoolean(CodingKeys.USER_LOGGED.getKey(), true);
        preferences.putString(CodingKeys.ACCESS_TOKEN.getKey(), response.getAccessToken());
        preferences.putString(CodingKeys.TOKEN_TYPE.getKey(), response.getTokenType());
    }

}
