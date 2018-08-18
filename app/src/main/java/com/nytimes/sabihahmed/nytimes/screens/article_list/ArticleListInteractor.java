package com.nytimes.sabihahmed.nytimes.screens.article_list;

import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import io.reactivex.Observable;

public interface ArticleListInteractor {

   void getNewsList(OnCompleteListener onCompleteListener);

   interface OnCompleteListener{
       void onCompleted(ResponseNews responseNews);
       void onFailure(Throwable e);

   }

}
