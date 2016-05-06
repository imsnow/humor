package com.elegant.humor.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elegant.humor.R;
import com.elegant.humor.model.Source;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * Created by Mike on 06.05.2016.
 */
public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.SourceViewHolder> {

    private List<Source> list;

    public SourcesAdapter(List<Source> list) {
        this.list = list;
    }

    @Override
    public SourcesAdapter.SourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_source, parent, false);
        return new SourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourcesAdapter.SourceViewHolder holder, int position) {
        Source item = list.get(position);
        holder.desc.setText(item.desc);
        holder.name.setText(item.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SourceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_source_desc) TextView desc;
        @BindView(R.id.item_source_name) TextView name;

        public SourceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
