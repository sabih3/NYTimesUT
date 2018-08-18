package com.nytimes.sabihahmed.nytimes.screens.article_list;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nytimes.sabihahmed.nytimes.BuildConfig;
import com.nytimes.sabihahmed.nytimes.data_source.ArticlesDataSource;
import com.nytimes.sabihahmed.nytimes.network.EndPoints;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleListInteractorImpl implements ArticleListInteractor {

    ArticlesDataSource api;

    public ArticleListInteractorImpl() {


            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        if(BuildConfig.DEBUG){
            httpClient.addInterceptor(loggingInterceptor);
        }



        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(EndPoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();


        api = retrofit.create(ArticlesDataSource.class);

    }


    @Override
    public void getNewsList(OnCompleteListener onCompleteListener) {
        api.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseNews>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseNews responseNews) {
                        onCompleteListener.onCompleted(responseNews);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleteListener.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
