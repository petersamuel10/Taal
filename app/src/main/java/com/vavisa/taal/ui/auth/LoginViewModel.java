package com.vavisa.taal.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.data.repository.LoginRepository;
import com.vavisa.taal.util.JsonParser;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LoginViewModel extends ViewModel {

    private SessionManager sessionManager;
    private LoginRepository loginRepository;

    @Inject
    LoginViewModel(LoginRepository loginRepository, SessionManager sessionManager) {
        this.loginRepository = loginRepository;
        this.sessionManager = sessionManager;
    }

    LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }

    void authWithCredentials(String email, String password) {
        sessionManager.authUser(queryUserCredentials(email, password));
    }

    private LiveData<AuthResource<User>> queryUserCredentials(String email, String password) {
        return LiveDataReactiveStreams.fromPublisher(loginRepository.loginUser(email, password)

                .onErrorReturn(throwable -> {
                    User errorUser = new User();
                    errorUser.setUserId("-1");
                    throwable.printStackTrace();
                    if (throwable instanceof HttpException) {
                        ResponseBody responseBody = ((HttpException) throwable).response().errorBody();
                        errorUser.setErrorMessage(JsonParser.getMessage(responseBody));
                    }
                    return errorUser;
                })
                .map((Function<User, AuthResource<User>>) user -> {
                    if (user.getUserId().equals("-1")) {
                        return AuthResource.error(user.getErrorMessage(), null);
                    }
                    return AuthResource.authenticated(user);
                })
                .subscribeOn(Schedulers.io()));
    }
}
