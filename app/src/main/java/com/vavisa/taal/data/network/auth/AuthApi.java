package com.vavisa.taal.data.network.auth;

import com.vavisa.taal.data.model.User;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {

    @FormUrlEncoded
    @POST("User/login")
    Flowable<User> userLogin(@Field("user_input") String username,
                             @Field("user_password") String password);

}
