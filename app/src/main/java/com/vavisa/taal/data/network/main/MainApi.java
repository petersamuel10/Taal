package com.vavisa.taal.data.network.main;

import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface MainApi {

    @GET("provider/categories")
    Observable<List<Category>> getCategories();

    @GET("user/getProfile")
    Observable<User> getUserProfile();

}
