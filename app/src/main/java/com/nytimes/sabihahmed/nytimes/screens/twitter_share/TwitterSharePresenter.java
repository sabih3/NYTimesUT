package com.nytimes.sabihahmed.nytimes.screens.twitter_share;

public class TwitterSharePresenter implements TwitterShareContract.Presenter,
                                              TwitterShareInteractor.OnAuthCompleteListener,
                                                TwitterShareInteractor.OnTweetPostListener{

    private final TwitterShareContract.View view;
    private final TwitterShareInteractorImpl twitterDataSource;

    public TwitterSharePresenter(TwitterShareContract.View viewListener,
                                 TwitterShareInteractorImpl twitterShareInteractorImpl) {
        this.view = viewListener;
        this.twitterDataSource = twitterShareInteractorImpl;

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onActivityPermissionResult() {
        if(true){
            view.onAuthSuccess();
        }else{
            view.onAuthError();
        }
    }

    @Override
    public void requestTwitterAuth() {
        twitterDataSource.makeAuthorizationRequest(this);
    }

    @Override
    public void requestTweet() {
        twitterDataSource.makeTweet(this);
    }

    @Override
    public void onAuthSuccess() {
        //TwitterAuthSuccess
        view.onAuthSuccess();

    }

    @Override
    public void onAuthException(String error) {
        //TwitterAuthError
        view.onAuthError();
    }

    @Override
    public void onTweetPostSuccess() {
        view.onTweetSuccess();
    }

    @Override
    public void onTweetPostError() {
        view.onTweetError();
    }
}
