package com.moashrafff.amazon_clone.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.Networking.ProductClient;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductViewModel extends ViewModel {

    public MutableLiveData<ArrayList<String>> categories = new MutableLiveData<>();
    public MutableLiveData<Product> productsLiveData = new MutableLiveData<>();

    public void getCategories() {
        Observable observable = ProductClient.getINSTANCE().getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<ArrayList<String>> observer = new Observer<ArrayList<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<String> strings) {
                categories.setValue(strings);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

    public void getProducts() {
        Observable observable = ProductClient.getINSTANCE().getProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observer <Product> observer = new Observer<Product>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Product product) {
                productsLiveData.setValue(product);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

}
