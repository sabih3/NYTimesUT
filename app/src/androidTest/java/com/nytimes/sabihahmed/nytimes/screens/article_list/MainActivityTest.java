package com.nytimes.sabihahmed.nytimes.screens.article_list;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nytimes.sabihahmed.nytimes.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureListIsPresent() {
        assertThat(getListInstance(),notNullValue());

    }

    @Test
    public void ensureListIsARecycler(){
        assertThat(getListInstance(),instanceOf(RecyclerView.class));
    }

    @Test
    public void ensureListIsVisible(){
        assertThat(getListInstance(), ViewMatchers.isDisplayed());
    }

    public RecyclerView getListInstance(){
        MainActivity activity = rule.getActivity();
        RecyclerView newsArticlesList = activity.findViewById(R.id.rv_articles);

        return newsArticlesList;
    }

    @Test
    public void ensureWebViewIsPresentAndVisible(){
        getListInstance().getChildAt(0).performClick();

        //validate intent and check its data
        intended(allOf(
                toPackage(" com.nytimes.sabihahmed.nytimes"),
                hasExtra("url", Matchers.hasValue(Matchers.any(String.class)))
        ));
    }
}