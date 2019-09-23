package com.vavisa.taal.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.vavisa.taal.data.model.LoginResponse;
import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.data.repository.LoginRepository;
import com.vavisa.taal.util.CodingKeys;
import com.vavisa.taal.util.Connectivity;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.Preferences;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LoginViewModel extends ViewModel {

    private SessionManager sessionManager;
    private LoginRepository loginRepository;
    private Preferences preferences;

    @Inject
    LoginViewModel(LoginRepository loginRepository, SessionManager sessionManager, Preferences preferences) {
        this.loginRepository = loginRepository;
        this.sessionManager = sessionManager;
        this.preferences = preferences;
    }

    LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }

    void authWithCredentials(String email, String password) {
        sessionManager.authUser(queryUserCredentials(email, password));
    }

    private LiveData<AuthResource<User>> queryUserCredentials(String email, String password) {
        return LiveDataReactiveStreams.fromPublisher(loginRepository.loginUser(email, password, "965789765456")
                .onErrorReturn(throwable -> {
                    LoginResponse errorResponse = new LoginResponse();
                    if (throwable instanceof HttpException) {
                        ResponseBody responseBody = ((HttpException) throwable).response().errorBody();
                        errorResponse.setMessage((JsonParser.getMessage(responseBody)));
                    }
                    return errorResponse;
                })
                .map((Function<LoginResponse, AuthResource<User>>) response -> {
                    if (response.getUser() == null) {
                        return AuthResource.error(response.getMessage(), null);
                    }
                    storeUserDetails(response);
                    return AuthResource.authenticated(response.getUser());
                })
                .subscribeOn(Schedulers.io()));
    }

    private void storeUserDetails(LoginResponse response) {
        String userJson = new Gson().toJson(response.getUser());
        preferences.putString(CodingKeys.USER_KEY.getKey(), userJson);
        preferences.putBoolean(CodingKeys.USER_LOGGED.getKey(), true);
        preferences.putString(CodingKeys.ACCESS_TOKEN.getKey(), response.getAccessToken());
        preferences.putString(CodingKeys.TOKEN_TYPE.getKey(), response.getTokenType());
    }
}
