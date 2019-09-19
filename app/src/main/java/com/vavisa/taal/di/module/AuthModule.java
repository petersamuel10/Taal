package com.vavisa.taal.di.module;

import com.vavisa.taal.data.network.auth.AuthApi;
import com.vavisa.taal.di.scope.AuthScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
