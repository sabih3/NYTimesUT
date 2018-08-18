package com.nytimes.sabihahmed.nytimes.screens.article_list;

import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import java.util.List;

public interface MainContract {

    interface View{

        void showProgress();
        void hideProgress();
        void onNewsFetchedSuccess(List<ResponseNews.Result> results);
        void onNewsFetchedFailure(Throwable e);

    }


    interface Presenter{

        void fetchNews();
        void onDestroy();
    }
}
