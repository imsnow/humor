package com.elegant.humor.model;

import java.util.List;

import rx.Observable;

/***
 * Created by Mike on 05.05.2016.
 */
public interface Model {

    Observable<List<Joke>>   getRandomJoke(int n);
    Observable<List<Joke>>   getJokesList(String site, String name, int n);
    Observable<List<List<Source>>> getSourcesList();
}
