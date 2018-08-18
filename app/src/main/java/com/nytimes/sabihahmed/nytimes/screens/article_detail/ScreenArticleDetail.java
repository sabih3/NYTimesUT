package com.nytimes.sabihahmed.nytimes.screens.article_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import com.nytimes.sabihahmed.nytimes.R;

import java.net.URL;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenArticleDetail extends AppCompatActivity {

    @BindView(R.id.wv_detail)WebView webViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        ButterKnife.bind(this);
        String url = getIntent().getStringExtra("url");
        URLEncoder.encode(url);
        webViewDetail.loadUrl(url);
    }
}
