package com.vavisa.taal.ui.auth;

import com.vavisa.taal.ui.main.MainActivity;

public class LoginEventHandler {
    private LoginActivity activity;

    public LoginEventHandler(LoginActivity activity) {
        this.activity = activity;
    }

    public void signUpClicked() {
        activity.start(MainActivity.class);
    }
}
