package com.vavisa.taal.data.network.interceptor;

import android.content.Context;

import com.vavisa.taal.BuildConfig;
import com.vavisa.taal.R;
import com.vavisa.taal.util.CodingKeys;
import com.vavisa.taal.util.Preferences;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private Preferences preferences;
    private Context context;

    public HeaderInterceptor(Context context) {
        this.context = context;
        this.preferences = new Preferences(context);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder headersBuilder = request.headers().newBuilder();
        headersBuilder.add(CodingKeys.VERSION_KEY.getKey(),  context.getResources().getString(R.string.version_prefix).concat(BuildConfig.VERSION_NAME));
        if (preferences.getString(CodingKeys.ACCESS_TOKEN.getKey()) != null)
            headersBuilder.add(CodingKeys.AUTHORIZATION.getKey(), preferences.getString(CodingKeys.ACCESS_TOKEN.getKey()));

        Headers headers = headersBuilder.build();
        request = request.newBuilder().headers(headers).build();
        return chain.proceed(request);
    }
}
