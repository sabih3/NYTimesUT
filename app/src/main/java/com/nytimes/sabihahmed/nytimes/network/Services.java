package com.nytimes.sabihahmed.nytimes.network;

import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Sabih Ahmed
 * ahmed.engr90@gmail.com
 */

public interface Services {

    @GET(EndPoints.URL_MOST_POPULAR)
    Observable<ResponseNews> getNews();
}
