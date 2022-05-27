package com.moashrafff.amazon_clone.Interfaces;

import com.moashrafff.amazon_clone.Data.Model.Product;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPoints {

    @GET("products/categories")
    public Observable<ArrayList<String>> getCategories();

    @GET("products")
    public Observable<ArrayList<Product>> getProducts();


}
