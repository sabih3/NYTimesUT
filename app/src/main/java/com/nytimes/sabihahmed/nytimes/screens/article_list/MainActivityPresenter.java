package com.nytimes.sabihahmed.nytimes.screens.article_list;

import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;



public class MainActivityPresenter implements MainContract.Presenter,
                                              ArticleListInteractor.OnCompleteListener{

    private ArticleListInteractorImpl newsListInteractor;
    private MainContract.View view;

    public MainActivityPresenter(MainContract.View listener,
                                 ArticleListInteractorImpl newsListInteractor) {
            view = listener;
            this.newsListInteractor = newsListInteractor;

    }


    //MainContract.Presenter
    @Override
    public void fetchNews() {
        view.showProgress();
        newsListInteractor.getNewsList(this);
    }

    //MainContract.Presenter
    @Override
    public void onDestroy() {
        view = null;
    }
    //ArticleListInteractor.OnCompleteListener
    @Override
    public void onCompleted(ResponseNews responseNews) {
        if(view != null){
            view.hideProgress();
            view.onNewsFetchedSuccess(responseNews.getResults());
        }
    }

    //ArticleListInteractor.OnCompleteListener
    @Override
    public void onFailure(Throwable e) {
        if(view !=null){
            view.hideProgress();
            view.onNewsFetchedFailure(e);
        }
    }
}
