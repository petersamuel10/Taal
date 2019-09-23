package com.vavisa.taal.data.network.interceptor;

import android.content.Context;

import com.vavisa.taal.util.Connectivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {

    private Context context;

    public NetworkConnectionInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (Connectivity.checkInternetConnection(context))
            return chain.proceed(request);
        else
            throw new NoInternetConnectionException(context);
    }
}