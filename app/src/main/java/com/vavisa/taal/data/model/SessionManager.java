package com.vavisa.taal.data.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.vavisa.taal.data.network.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager(){}

    public void authUser(final LiveData<AuthResource<User>> source){
        if (cachedUser != null){
            cachedUser.setValue(AuthResource.loading(null));
            cachedUser.addSource(source, userAuthResource -> {
                cachedUser.setValue(userAuthResource);
                cachedUser.removeSource(source);
            });
        }
    }

    public void logOut(){
        cachedUser.setValue(AuthResource.<User>logout());
    }

    public void setCachedUser(AuthResource<User> userAuthResource) {
        cachedUser.setValue(userAuthResource);
    }

    public LiveData<AuthResource<User>> getAuthUser(){
        return cachedUser;
    }
}
