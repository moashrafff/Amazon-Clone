package com.moashrafff.amazon_clone.Networking;

import com.moashrafff.amazon_clone.Config.Constants;
import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.Interfaces.EndPoints;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient {

    private EndPoints Interface;
    private static ProductClient INSTANCE;

    public ProductClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Interface = retrofit.create(EndPoints.class);
    }

    public static ProductClient getINSTANCE () {
        if (null == INSTANCE){
            INSTANCE = new ProductClient();
        }
        return INSTANCE;
    }

    public Observable<ArrayList<String>> getCategories(){
        return Interface.getCategories();
    }

    public Observable<ArrayList<Product>> getProducts(){
        return Interface.getProducts();
    }
}
