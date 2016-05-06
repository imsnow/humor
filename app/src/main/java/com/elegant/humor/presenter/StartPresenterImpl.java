package com.elegant.humor.presenter;

import android.util.Log;
import android.view.View;

import com.elegant.humor.model.Joke;
import com.elegant.humor.model.Model;
import com.elegant.humor.model.ModelImpl;
import com.elegant.humor.model.Source;
import com.elegant.humor.view.IStartView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/***
 * Created by Mike on 06.05.2016.
 */
public class StartPresenterImpl implements StartPresenter {

    private Model model = new ModelImpl();

    private IStartView view;
    private Subscription subscription = Subscriptions.empty();

    public StartPresenterImpl(IStartView view) {
        this.view = view;
    }

    @Override
    public void loadRandom() {
        //if (!subscription.isUnsubscribed())
        //    subscription.unsubscribe();

        subscription = model.getRandomJoke(50)
                .subscribe(new Observer<List<Joke>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", e.getMessage());
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Joke> jokes) {

                        String site;

                        Locale locale = Locale.getDefault();
                        if (locale.getLanguage().equals("en"))
                            site = "xkcdb.com";
                        else site = "bash.im";

                        for (Joke item : jokes){
                            if (item.site.equals(site))
                                view.updateRandomJoke(item);
                        }

                        //view.updateRandomJoke(jokes.get(0));
                    }
                });
    }

    @Override
    public void loadSourcesList() {
        //if (!subscription.isUnsubscribed())
        //    subscription.unsubscribe();

        subscription = model.getSourcesList()
                .subscribe(new Observer<List<List<Source>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<List<Source>> lists) {
                        List<Source> result = new ArrayList<>();
                        if (lists != null && !lists.isEmpty()) {
                            for (List<Source> innerList : lists)
                                result.addAll(innerList);

                            view.showSourcesList(result);
                        }
                        else
                            view.showEmptyList();
                    }
                });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
