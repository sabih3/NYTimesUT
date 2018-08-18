package com.nytimes.sabihahmed.nytimes.screens.article_list;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nytimes.sabihahmed.nytimes.R;
import com.nytimes.sabihahmed.nytimes.adapters.ArticlesAdapter;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;
import com.nytimes.sabihahmed.nytimes.screens.article_detail.ScreenArticleDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View,
             ArticlesAdapter.onArticleInteractionListener{

    private MainActivityPresenter presenter;

    @BindView(R.id.swipe_refresh_news)SwipeRefreshLayout swipe_refresh;
    @BindView(R.id.rv_articles)RecyclerView recycler_articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainActivityPresenter(this,new ArticleListInteractorImpl());
        swipe_refresh.setOnRefreshListener(new SwipeRefreshListener());

        fetchNews();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    //ArticlesAdapter
    @Override
    public void onArticleTapListener(ResponseNews.Result article) {
        Intent intent = new Intent(this, ScreenArticleDetail.class);
        intent.putExtra("url",article.getUrl());
        startActivity(intent);

    }

    @Override
    public void showProgress() {
        swipe_refresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipe_refresh.setRefreshing(true);
    }

    @Override
    public void onNewsFetchedSuccess(List<ResponseNews.Result> results) {
            setData(results);
    }

    @Override
    public void onNewsFetchedFailure(Throwable e) {

    }


    private class SwipeRefreshListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            fetchNews();
        }
    }

    /************************************* Private Methods ****************************************/
    private void fetchNews() {
        presenter.fetchNews();
    }

    private void setData(List<ResponseNews.Result> results) {
        recycler_articles.setLayoutManager(new LinearLayoutManager(this));
        ArticlesAdapter adapter = new ArticlesAdapter(results);
        adapter.setInteractionListener(this);
        recycler_articles.setAdapter(adapter);
    }


}
