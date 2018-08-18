package com.nytimes.sabihahmed.nytimes.network;

/**
 * Created by Sabih Ahmed
 */

public class EndPoints {

    public static final String BASE_URL = "http://api.nytimes.com/svc/";


    public static final String URL_MOST_POPULAR = "mostpopular/v2/mostviewed/"
                               +Constants.NewsConfiguration.CURRENT_SECTIONS_CONFIGURATION
                               +Constants.NewsConfiguration.CONFIGURED_PERIOD
                               +".json"
                               +"?api-key="
                               +Constants.NewsConfiguration.API_KEY;

}
