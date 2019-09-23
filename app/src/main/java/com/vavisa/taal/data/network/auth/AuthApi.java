package com.vavisa.taal.data.network.auth;

import com.vavisa.taal.data.model.LoginResponse;
import com.vavisa.taal.data.model.User;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {

    @FormUrlEncoded
    @POST("user/login")
    Flowable<LoginResponse> userLogin(@Field("email") String email,
                                      @Field("password") String password,
                                      @Field("player_id") String playerId,
                                      @Field("device_type") Integer deviceType);

}
