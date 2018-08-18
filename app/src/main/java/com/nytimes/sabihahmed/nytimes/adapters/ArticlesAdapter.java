package com.nytimes.sabihahmed.nytimes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nytimes.sabihahmed.nytimes.R;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticleHolder> {

    private List<ResponseNews.Result> mDataset;
    private Context mContext;
    private onArticleInteractionListener interactionListener;

    public void setInteractionListener(onArticleInteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }

    public ArticlesAdapter(List<ResponseNews.Result> results) {
        this.mDataset = results;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       this.mContext = parent.getContext();
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_article, parent,false);
        ArticleHolder holder = new ArticleHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        ResponseNews.Result article = mDataset.get(position);
        holder.bindData(article);

        holder.rowParent.setOnClickListener(view -> {
            interactionListener.onArticleTapListener(article);
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface onArticleInteractionListener{
        void onArticleTapListener(ResponseNews.Result article);
    }
}

