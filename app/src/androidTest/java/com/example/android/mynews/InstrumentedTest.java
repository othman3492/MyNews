package com.example.android.mynews;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.mynews.Controllers.Activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickOnArticle_opensWebView() {

        onView(withId(R.id.article_view)).perform(click());
        onView(withId(R.layout.activity_article)).check(matches(isDisplayed()));
    }


    @Test
    public void swipeLeftandRight_changeCategory() {

        onView(withId(R.id.activity_main_viewpager)).perform(swipeLeft());
        onView(withText("MOST POPULAR")).check(matches(isDisplayed()));

        onView(withId(R.id.activity_main_viewpager)).perform(swipeRight());
        onView(withText("TOP STORIES")).check(matches(isDisplayed()));
    }


    @Test
    public void clickSearchButton_opensSearchActivity() {

        onView(withId(R.id.menu_activity_main_search)).perform(click());
        onView(withId(R.id.search_button)).check(matches(isDisplayed()));
    }


    @Test
    public void clickNotificationButton_opensNotificationsActivity() {

        onView(withId(R.id.menu_activity_main_notifications)).perform(click());
        onView(withId(R.id.notification_switch)).check(matches(isDisplayed()));
    }


    @Test
    public void clickCategoryInNavigationDrawer_opensCategory() {

        onView(withId(R.id.activity_main_drawer_automobiles)).perform(click());
        onView(withText("AUTOMOBILES")).check(matches(isDisplayed()));
    }
}
