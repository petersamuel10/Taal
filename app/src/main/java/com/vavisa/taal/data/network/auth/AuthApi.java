package com.vavisa.taal.data.network.auth;

import com.vavisa.taal.data.model.AuthResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {

    @FormUrlEncoded
    @POST("user/login")
    Flowable<AuthResponse> userLogin(@Field("email") String email,
                                     @Field("password") String password,
                                     @Field("player_id") String playerId,
                                     @Field("device_type") Integer deviceType);

    @FormUrlEncoded
    @POST("user/register")
    Flowable<AuthResponse> userRegister(@Field("fullname") String fullName,
                                        @Field("email") String email,
                                        @Field("mobile") String mobile,
                                        @Field("password") String password,
                                        @Field("confirm_password") String confirmPassword);

}
