package com.elegant.humor.presenter;

/***
 * Created by Mike on 06.05.2016.
 */
public interface StartPresenter {

    void loadRandom();
    void loadSourcesList();
    void clickedToIndex(int position);
    void onStop();
}
