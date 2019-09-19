package com.vavisa.taal.di.module;

import android.app.Application;
import android.content.Context;

import com.vavisa.taal.BuildConfig;
import com.vavisa.taal.data.network.interceptor.HeaderInterceptor;
import com.vavisa.taal.util.Preferences;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideAppContext(Application context){
        return context;
    }

    @Singleton
    @Provides
    Preferences providePreferences(Application context){
        return new Preferences(context);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofitInstance(Application context){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(60, TimeUnit.SECONDS);
        client.connectTimeout(60, TimeUnit.SECONDS);
        client.addInterceptor(new HeaderInterceptor(context));
        client.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

}