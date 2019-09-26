package com.vavisa.taal.ui.auth.login;

import com.vavisa.taal.ui.auth.register.RegisterActivity;

public class LoginEventHandler {

    private LoginActivity activity;

    LoginEventHandler(LoginActivity activity) {
        this.activity = activity;
    }

    public void signUpClicked() {
        activity.start(RegisterActivity.class);
    }
}
