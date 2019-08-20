package com.example.android.mynews.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.mynews.Controllers.Fragments.ArticlesFragment;

public class PageAdapter extends FragmentPagerAdapter {


    public PageAdapter(FragmentManager manager) {

        super(manager);
    }


    @Override
    public Fragment getItem(int i) {

        return ArticlesFragment.newInstance(i);
    }


    public int getCount() {

        return 3;
    }



    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0 :
                return "TOP STORIES";
            case 1 :
                return "MOST POPULAR";
            case 2 :
                return "INTERNATIONAL";
            default :
                return null;
        }
    }
}


