package com.vavisa.taal.ui.auth.register;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.repository.RegisterRepository;
import com.vavisa.taal.ui.auth.AuthViewModel;
import com.vavisa.taal.util.FormValidation;
import com.vavisa.taal.util.Preferences;

import javax.inject.Inject;

public class RegisterViewModel extends AuthViewModel {

    private RegisterRepository registerRepository;

    public MutableLiveData<String> nameError = new MutableLiveData<>();
    public MutableLiveData<String> emailError = new MutableLiveData<>();
    public MutableLiveData<String> mobileError = new MutableLiveData<>();
    public MutableLiveData<String> passwordError = new MutableLiveData<>();
    public MutableLiveData<String> confirmPasswordError = new MutableLiveData<>();

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> mobile = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> confirmPassword = new MutableLiveData<>();

    @Inject
    RegisterViewModel(RegisterRepository registerRepository, SessionManager sessionManager, Preferences preferences, Context context) {
        this.registerRepository = registerRepository;
        this.sessionManager = sessionManager;
        this.preferences = preferences;
        this.context = context;
    }

    @Override
    public boolean isValidInput() {
        FormValidation formValidation = new FormValidation(context);
        return formValidation.isValidName(name.getValue(), nameError)
                && formValidation.isValidEmail(email.getValue(), emailError)
                && formValidation.isValidPhone(mobile.getValue(), mobileError)
                && formValidation.isValidPassword(password.getValue(), passwordError)
                && formValidation.isPasswordMatch(password.getValue(), confirmPassword.getValue(), confirmPasswordError);
    }

    @Override
    public void authWithCredentials() {
        sessionManager.authUser(queryUserCredentials(registerRepository
                .registerUser(name.getValue(),
                        email.getValue(),
                        mobile.getValue(),
                        password.getValue(),
                        confirmPassword.getValue())));
    }

}
