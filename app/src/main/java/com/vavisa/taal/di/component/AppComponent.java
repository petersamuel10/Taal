package com.vavisa.taal.di.component;

import android.app.Application;

import com.vavisa.taal.base.BaseApplication;
import com.vavisa.taal.data.model.SessionManager;
import com.vavisa.taal.di.module.ActivityBuildersModule;
import com.vavisa.taal.di.module.AppModule;
import com.vavisa.taal.di.util.ViewModelProviderFactory;
import com.vavisa.taal.util.Preferences;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuildersModule.class, AppModule.class, ViewModelProviderFactory.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();
    Preferences preferences();

    @Component.Builder
    interface Builder{

        @BindsInstance

        Builder application(Application application);
        AppComponent build();
    }
}
