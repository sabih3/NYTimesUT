package com.nytimes.sabihahmed.nytimes.screens.twitter_share;

public interface TwitterShareContract {


    //=========================== View Actions ====================================
    interface View{
        void showProgress();
        void hideProgress();
        void onAuthSuccess();
        void onAuthError();
        void onTweetSuccess();
        void onTweetError();

    }

    //========================= Presenter's Responsibilities =======================
    interface Presenter{
        void onDestroy(); // To handle View Lifecycle
        void onPause();  // To handle View Lifecycle, when another view comes over this view
        void onResume();// To handle View Lifecycle, when view comes back in foreground

        void onActivityPermissionResult(); //Result of Activity Permission
        void requestTwitterAuth();         //Twitter Auth request
        void requestTweet();               //Twitter Post Request

    }
}
