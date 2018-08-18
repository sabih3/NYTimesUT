package com.nytimes.sabihahmed.nytimes.screens.twitter_share;

public interface TwitterShareInteractor {

    //============================ Authentication Part ===============================//
    void makeAuthorizationRequest(OnAuthCompleteListener onAuthCompleteListener);

    interface OnAuthCompleteListener{
        void onAuthSuccess();
        void onAuthException(String error);
    }



    //========================== Tweet Part =========================================//
    void makeTweet(OnTweetPostListener onTweetPostListener);

    interface OnTweetPostListener{
        void onTweetPostSuccess();
        void onTweetPostError();
    }
}
