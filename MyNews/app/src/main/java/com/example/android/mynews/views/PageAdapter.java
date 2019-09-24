package com.example.android.mynews.views;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.mynews.controllers.fragments.ArticlesFragment;

public class PageAdapter extends FragmentPagerAdapter {


    public PageAdapter(FragmentManager manager) {

        super(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    }


    @NonNull
    @Override
    public Fragment getItem(int i) {

        return ArticlesFragment.newInstance(i);
    }


    // Set the number of tabs
    public int getCount() {

        return 10;
    }



    // Set title for every tab depending on position
    public String getPageTitle(int position) {


        switch (position) {

            case 0 :
                return "TOP STORIES";
            case 1 :
                return "MOST POPULAR";
            case 2 :
                return "WORLD";
            case 3 :
                return "POLITICS";
            case 4 :
                return "NATIONAL";
            case 5 :
                return "BUSINESS";
            case 6 :
                return "SPORTS";
            case 7 :
                return "TECHNOLOGY";
            case 8 :
                return "SCIENCE";
            case 9 :
                return "AUTOMOBILES";
            default :
                return null;
        }
    }
}


