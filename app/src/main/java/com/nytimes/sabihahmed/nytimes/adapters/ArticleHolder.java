package com.nytimes.sabihahmed.nytimes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nytimes.sabihahmed.nytimes.R;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import butterknife.BindView;
import butterknife.ButterKnife;

class ArticleHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.row_article_parent)public RelativeLayout rowParent;
    @BindView(R.id.tv_abrevation) TextView tvAbrevation;
    @BindView(R.id.tv_news_title)TextView tvNewsTitle;
    @BindView(R.id.tv_author)TextView tvNewsAuthor;
    @BindView(R.id.tv_date)TextView tvNewsDate;

    public ArticleHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindData(ResponseNews.Result article) {
        char c = article.getTitle().charAt(0);
        tvAbrevation.setText(String.valueOf(c));
        tvNewsTitle.setText(article.getTitle());
        tvNewsAuthor.setText(article.getByline());
        tvNewsDate.setText(article.getPublished_date());
    }
}
