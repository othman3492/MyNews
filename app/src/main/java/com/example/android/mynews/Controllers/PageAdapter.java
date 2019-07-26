package com.example.android.mynews.Controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {


    PageAdapter(FragmentManager manager) {

        super(manager);
    }


    public int getCount() {

        return 3;
    }


    public Fragment getItem(int position) {

        switch (position) {

            case 0 :
                return TopStoriesFragment.newInstance();
            case 1 :
                return MostPopularFragment.newInstance();
            case 2 :
                return ArticleSearchFragment.newInstance();
            default :
                return null;
        }
    }


    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0 :
                return "TOP STORIES";
            case 1 :
                return "MOST POPULAR";
            case 2 :
                return "ARTICLE SEARCH";
            default :
                return null;
        }
    }
}


