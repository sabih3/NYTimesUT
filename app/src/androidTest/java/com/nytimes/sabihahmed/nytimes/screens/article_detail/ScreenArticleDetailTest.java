package com.nytimes.sabihahmed.nytimes.screens.article_detail;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import com.nytimes.sabihahmed.nytimes.screens.article_list.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ScreenArticleDetailTest {

    @Rule
    ActivityTestRule<ScreenArticleDetail> rule = new ActivityTestRule<>(ScreenArticleDetail.class);

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);


}