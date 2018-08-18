package com.nytimes.sabihahmed.nytimes.screens.article_list;

import com.nytimes.sabihahmed.nytimes.data_source.ArticlesDataSource;
import com.nytimes.sabihahmed.nytimes.network.model.responses.ResponseNews;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    public ArticlesDataSource articlesDataSource;

    @Mock
    public MainContract.View view;

    @Mock
    public ArticleListInteractorImpl newsListInteraction;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchNewsTest(){

        ResponseNews responseNews = new ResponseNews();
        when(articlesDataSource.getNews()).thenReturn(Observable.just(responseNews));

        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(view,
                                                      newsListInteraction);

        mainActivityPresenter.fetchNews();

        InOrder inOrder = Mockito.inOrder(view);

        inOrder.verify(view,times(1)).showProgress();

    }
}