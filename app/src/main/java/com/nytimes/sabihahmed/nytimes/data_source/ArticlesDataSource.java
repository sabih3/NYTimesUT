package com.nytimes.sabihahmed.nytimes.data_source;

import com.nytimes.sabihahmed.nytimes.network.EndPoints;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ArticlesDataSource {
    @GET(EndPoints.URL_MOST_POPULAR)
    Observable<ResponseNews> getNews();
}
