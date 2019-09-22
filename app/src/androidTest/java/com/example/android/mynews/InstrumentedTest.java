package com.example.android.mynews;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.android.mynews.controllers.activities.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



public class InstrumentedTest {

    @Rule
    public final ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickOnArticle_openWebView() {

        onView(ViewMatchers.withId(R.id.articles_recycler_view))
                .inRoot(RootMatchers.withDecorView(Matchers.is(activityTestRule.getActivity().getWindow().getDecorView())))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

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
