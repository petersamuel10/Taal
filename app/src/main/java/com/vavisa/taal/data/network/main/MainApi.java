package com.vavisa.taal.data.network.main;

import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MainApi {

    @GET("provider/categories")
    Observable<List<Category>> getCategories();

    @GET("user/getCaseParameters/{category_id}")
    Observable<List<Parameter>> getCategoryParameters(@Path("category_id") Integer categoryId);

    @GET("user/getProfile")
    Observable<User> getUserProfile();

}
