package com.nytimes.sabihahmed.nytimes.screens.twitter_share;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nytimes.sabihahmed.nytimes.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

public class ScreenTwitterShare extends AppCompatActivity implements TwitterShareContract.View{

    TwitterSharePresenter presenter;
    Button shareButton;
    Button tweetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_twitter_share);

        //request Twitter Auth
        presenter.requestTwitterAuth();

        tweetButton.setOnClickListener(new TweetButtonListener());

        TwitterAuthClient authClient = new TwitterAuthClient();
        authClient.authorize(this, new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

            }

            @Override
            public void failure(TwitterException exception) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //depends on the result, proceed
        presenter.onActivityPermissionResult();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onAuthSuccess() {
        //show Composer UI
    }

    @Override
    public void onAuthError() {
        //Notify User and handle
    }

    @Override
    public void onTweetSuccess() {
        //Handle Tweet posted Success
    }

    @Override
    public void onTweetError() {
        //Handle Tweet Post Error
    }

    private class TweetButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            presenter.requestTweet();
        }
    }
}
