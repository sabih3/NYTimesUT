package com.nytimes.sabihahmed.nytimes;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

public class Application extends android.app.Application{

    //TODO need to change the keys
    @SuppressWarnings("SpellCheckingInspection")
    public static final String TWITTER_KEY = "Hgt8d2nLhZdQUaIvsyxYuPhb5";
    @SuppressWarnings("SpellCheckingInspection")
    public static final String TWITTER_SECRET = "MeliZLYavlMiyhYTs97zyTCUOzznnog9cIrgfRHfc0TbN9PkP4";


    @Override
    public void onCreate() {
        super.onCreate();

        Twitter.initialize(new TwitterConfig.Builder(this)
                                .twitterAuthConfig(new TwitterAuthConfig(
                                                   TWITTER_KEY,TWITTER_SECRET)).build());
    }
}
