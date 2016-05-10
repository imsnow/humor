package com.elegant.humor.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elegant.humor.R;
import com.elegant.humor.model.Joke;
import com.elegant.humor.model.Source;
import com.elegant.humor.presenter.ListPresenter;
import com.elegant.humor.presenter.ListPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * Created by Mike on 10.05.2016.
 */
public class JokesListFragment extends Fragment implements IListView {

    @BindView(R.id.jokes_list)
    RecyclerView jokesListView;

    private ListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_joke_list, container, false);
        ButterKnife.bind(this, v);

        Bundle bundle = getArguments();
        Source source = bundle.getParcelable("SOURCE");
        presenter = new ListPresenterImpl(this, source);

        presenter.loadSourcesList();

        return v;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showJokesList(List<Joke> list) {
        JokesListAdapter adapter = new JokesListAdapter(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();

        jokesListView.setAdapter(adapter);
        jokesListView.setLayoutManager(layoutManager);
        jokesListView.setItemAnimator(animator);
    }

    @Override
    public void showEmptyList() {

    }

    @Override
    public void showError(String error) {

    }
}
