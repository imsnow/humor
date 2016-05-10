package com.elegant.humor.presenter;

import android.util.Log;

import com.elegant.humor.model.Joke;
import com.elegant.humor.model.Model;
import com.elegant.humor.model.ModelImpl;
import com.elegant.humor.model.Source;
import com.elegant.humor.view.IListView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/***
 * Created by Mike on 10.05.2016.
 */
public class ListPresenterImpl implements ListPresenter {

    private Model model = new ModelImpl();
    private IListView view;
    private Subscription subscription = Subscriptions.empty();

    private Source source;

    public ListPresenterImpl(IListView view, Source source) {
        this.view = view;
        this.source = source;
    }

    @Override
    public void loadSourcesList() {
        subscription = model.getJokesList(source.site, source.name, 50).subscribe(new Observer<List<Joke>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("TAG", "error = " + e.getMessage());
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Joke> jokes) {
                if (jokes != null && !jokes.isEmpty()) {
                    view.showJokesList(jokes);
                }
                else
                    view.showEmptyList();
            }
        });
    }

    @Override
    public void onStop() {
        view = null;
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
