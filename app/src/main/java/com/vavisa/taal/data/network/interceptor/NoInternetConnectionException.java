package com.vavisa.taal.data.network.interceptor;

import android.content.Context;

import com.vavisa.taal.R;

import java.io.IOException;

public class NoInternetConnectionException extends IOException {

    private Context context;

    NoInternetConnectionException(Context context) {
        this.context = context;
    }

    @Override
    public String getMessage() {
        return context.getResources().getString(R.string.no_internet_connection);
    }
}
