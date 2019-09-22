package com.vavisa.taal.di.module;

import com.vavisa.taal.data.network.main.MainApi;
import com.vavisa.taal.di.scope.MainScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
class MainModule {

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

}
