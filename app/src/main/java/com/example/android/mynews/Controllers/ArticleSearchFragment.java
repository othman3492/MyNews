package com.example.android.mynews.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.R;


public class ArticleSearchFragment extends Fragment {


    public ArticleSearchFragment() {
        // Required empty public constructor
    }


    public static ArticleSearchFragment newInstance() {

        return new ArticleSearchFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_search, container, false);
    }

}
