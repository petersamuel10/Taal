package com.vavisa.taal.ui.auth.login;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.repository.LoginRepository;
import com.vavisa.taal.ui.auth.base.AuthViewModel;
import com.vavisa.taal.util.FormValidation;
import com.vavisa.taal.util.Preferences;

import javax.inject.Inject;

public class LoginViewModel extends AuthViewModel {

    private LoginRepository loginRepository;

    public MutableLiveData<String> passwordError = new MutableLiveData<>();
    public MutableLiveData<String> emailError = new MutableLiveData<>();

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    @Inject
    LoginViewModel(LoginRepository loginRepository, SessionManager sessionManager, Preferences preferences, Context context) {
        this.loginRepository = loginRepository;
        this.sessionManager = sessionManager;
        this.preferences = preferences;
        this.context = context;
    }

    @Override
    public boolean isValidInput() {
        FormValidation formValidation = new FormValidation(context);
        return  formValidation.isValidEmail(email.getValue(), emailError)
                &&  formValidation.isValidPassword(password.getValue(), passwordError);
    }

    @Override
    public void authWithCredentials() {
        sessionManager.authUser(queryUserCredentials(loginRepository
                .loginUser(email.getValue(),
                        password.getValue(),
                        "965789765456")));
    }
}
