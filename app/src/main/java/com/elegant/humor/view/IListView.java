package com.elegant.humor.view;

import com.elegant.humor.model.Joke;

import java.util.List;

/**&
 * Created by Mike on 10.05.2016.
 */
public interface IListView {
    void showProgressBar();
    void hideProgressBar();
    void showJokesList(List<Joke> list);
    void showEmptyList();

    void showError(String error);
}
