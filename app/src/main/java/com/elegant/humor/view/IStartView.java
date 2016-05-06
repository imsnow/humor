package com.elegant.humor.view;

import com.elegant.humor.model.Joke;
import com.elegant.humor.model.Source;

import java.util.List;

/***
 * Created by Mike on 06.05.2016.
 */
public interface IStartView {

    void updateRandomJoke(Joke joke);
    void showProgressBar();
    void hideProgressBar();
    void showSourcesList(List<Source> list);
    void showEmptyList();

    void showError(String error);
}
