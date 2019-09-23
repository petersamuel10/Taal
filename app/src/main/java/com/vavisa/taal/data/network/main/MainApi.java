package com.vavisa.taal.data.network.main;


import com.vavisa.taal.data.model.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface MainApi {

    @GET("user/getProfile")
    Observable<User> getUserProfile();

}
