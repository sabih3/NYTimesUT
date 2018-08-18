package com.nytimes.sabihahmed.nytimes;

import com.google.gson.Gson;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;
import com.nytimes.sabihahmed.nytimes.screens.article_list.ArticleListInteractorImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.reactivex.subscribers.TestSubscriber;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(JUnit4.class)
public class APICallsTest {

    MockWebServer mockWebServer;
    TestSubscriber<ResponseNews> testSubscriber;
    ArticleListInteractorImpl newsListInteractionImpl;




    @Before
    public void setUp() throws Exception {

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        newsListInteractionImpl = new ArticleListInteractorImpl();

        testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void testSuccessResponse() {
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody()
    }


    private ResponseNews getDummyNews(){

        Gson gson = new Gson();
        gson.fromJson(FileHelper.getFile(this));
    }
}
