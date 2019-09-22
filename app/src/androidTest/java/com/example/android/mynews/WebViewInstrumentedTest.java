package com.example.android.mynews;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.android.mynews.controllers.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
public class WebViewInstrumentedTest {

    private CountingIdlingResource myIdlingResource;

    public WebViewInstrumentedTest() {
        myIdlingResource = new CountingIdlingResource("MyNews");
        IdlingRegistry.getInstance().register(myIdlingResource);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickOnArticle_opensWebView() {

        onView(allOf(withId(R.id.articles_recycler_view), isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.article_web_view)).check(matches(isDisplayed()));
        IdlingRegistry.getInstance().unregister(myIdlingResource);
    }
}
