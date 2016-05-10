package com.elegant.humor.model;

import java.util.List;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/***
 * Created by Mike on 06.05.2016.
 */
public class ModelImpl implements Model {

    private ApiInterface apiInterface;

    public ModelImpl() {

        OkHttpClient client = new OkHttpClient();

        apiInterface = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(ApiInterface.class);
    }

    @Override
    public Observable<List<Joke>> getRandomJoke(int n) {
        return apiInterface.getRandomJoke(n)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Joke>> getJokesList(String site, String name, int n) {
        return apiInterface.getJokesList(site, name, n)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<List<Source>>> getSourcesList() {
        return apiInterface.getSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
