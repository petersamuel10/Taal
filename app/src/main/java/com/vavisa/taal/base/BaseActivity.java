package com.vavisa.taal.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.data.network.auth.AuthResource;
import com.vavisa.taal.data.network.interceptor.InternetConnectionListener;
import com.vavisa.taal.ui.auth.login.LoginActivity;
import com.vavisa.taal.util.JsonParser;
import com.vavisa.taal.util.Preferences;
import com.vavisa.taal.util.ProgressDialog;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    public SessionManager sessionManager;

    @Inject
    public Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers(){
        sessionManager.getAuthUser().observe(this, userAuthResource -> {
            if (userAuthResource != null && userAuthResource.status == AuthResource.AuthStatus.NOT_AUTHENTICATED) {
                navLoginScreen();
            }
        });
    }

    private void navLoginScreen() {
        start(LoginActivity.class);
    }

    public void start(Class<? extends BaseActivity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void showProgress() {
        ProgressDialog.getInstance().show(this);
    }

    public void hideProgress() {
        ProgressDialog.getInstance().dismiss();
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showErrorMessage(Throwable error) {
        if (error instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) error).response().errorBody();
            showMessage(JsonParser.getErrorMessage(responseBody));
        } else
            showMessage(error.getMessage());
    }

}
