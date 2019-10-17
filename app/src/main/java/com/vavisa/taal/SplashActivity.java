package com.vavisa.taal;


import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.vavisa.taal.base.BaseActivity;
import com.vavisa.taal.data.model.User;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.ui.auth.login.LoginActivity;
import com.vavisa.taal.ui.main.navigation.NavigationActivity;
import com.vavisa.taal.util.CodingKeys;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                checkAuthStatus();
            }
        }, 1000);
    }

    private void checkAuthStatus() {
        Intent navigationIntent;
        if (preferences.getBoolean(CodingKeys.USER_LOGGED.getKey())) {
            setAuthUser();
            navigationIntent = new Intent(this, NavigationActivity.class);
        } else
            navigationIntent = new Intent(this, LoginActivity.class);
        startActivity(navigationIntent);
        finish();
    }

    private void setAuthUser() {
        String userJson = preferences.getString(CodingKeys.USER_KEY.getKey());
        User user = new Gson().fromJson(userJson, User.class);
        runOnUiThread(() -> {
            sessionManager.setCachedUser(AuthResource.authenticated(user));
        });
    }

}
