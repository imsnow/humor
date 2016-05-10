package com.elegant.humor.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elegant.humor.R;
import com.elegant.humor.model.Joke;
import com.elegant.humor.model.Source;
import com.elegant.humor.presenter.StartPresenter;
import com.elegant.humor.presenter.StartPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * Created by Mike on 06.05.2016.
 */
public class StartFragment extends Fragment implements IStartView, View.OnClickListener {

    private StartPresenter presenter;

    @BindView(R.id.random_card)
    CardView randomCard;
    @BindView(R.id.randomTextView)
    TextView randomTextView;
    @BindView(R.id.random_source)
    TextView randomSourceTextView;
    @BindView(R.id.parent)
    LinearLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_start, container, false);

        ButterKnife.bind(this, v);

        randomTextView.setOnClickListener(this);
        presenter = new StartPresenterImpl(this);
        presenter.loadRandom();
        presenter.loadSourcesList();
        return v;
    }

    @Override
    public void updateRandomJoke(Joke joke) {

        randomTextView.setText("");
        randomTextView.setText(Html.fromHtml(joke.elementPureHtml));
        randomSourceTextView.setText(joke.desc);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showSourcesList(List<Source> list) {

        for (int i=0; i<list.size(); i++)
            addCardView(layout, list.get(i), i);
        //for (Source item : list)
        //    addCardView(layout, item, list.ge);
        /*
        SourcesAdapter adapter = new SourcesAdapter(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();

        sourcesList.setAdapter(adapter);
        sourcesList.setLayoutManager(layoutManager);
        sourcesList.setItemAnimator(animator);
        */
    }

    @Override
    public void showEmptyList() {

    }

    @Override
    public void showListFragment(Source source) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SOURCE", source);
        JokesListFragment listFragment = new JokesListFragment();
        listFragment.setArguments(bundle);

        getFragmentManager().beginTransaction()
                .add(R.id.container, listFragment).commit();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.randomTextView)
            presenter.loadRandom();
        else {
            if (v.getTag() != null) {
                Integer position = (Integer) v.getTag();
                Log.d("TAG", "clicked = " + position);
                presenter.clickedToIndex(position);
            }
        }
    }


    private void addCardView(ViewGroup parent, Source source, int i) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_source, parent, false);
        TextView desc = (TextView) view.findViewById(R.id.item_source_desc);
        TextView name = (TextView) view.findViewById(R.id.item_source_name);
        desc.setText(source.desc);
        name.setText(source.name);
        view.setTag(i);
        view.setOnClickListener(this);

        layout.addView(view);
    }

}
