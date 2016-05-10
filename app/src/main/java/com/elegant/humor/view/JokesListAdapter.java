package com.elegant.humor.view;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elegant.humor.R;
import com.elegant.humor.model.Joke;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**^
 * Created by Mike on 10.05.2016.
 */
public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.JokeViewHolder> {

    private List<Joke> list;

    public JokesListAdapter(List<Joke> list) {
        this.list = list;
    }

    @Override
    public JokesListAdapter.JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JokesListAdapter.JokeViewHolder holder, int position) {
        Joke item = list.get(position);
        holder.elementPureHtml.setText(Html.fromHtml(item.elementPureHtml));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class JokeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_joke_desc) TextView elementPureHtml;

        public JokeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
