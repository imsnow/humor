package com.elegant.humor.model;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/***
 * Created by Mike on 05.05.2016.
 */
public interface ApiInterface {

    @GET("random?")
    Observable<List<Joke>> getRandomJoke(@Query("num") int n);

    @GET("get?")
    Observable<List<Joke>> getJokesList(@Query("site") String site, @Query("name") String name, @Query("num") int num);

    @GET("sources")
    Observable<List<List<Source>>> getSources();
}
