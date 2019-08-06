package com.example.android.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.R;
import com.example.android.mynews.Views.ArticleSearchAdapter;
import com.example.android.mynews.Views.TopStoriesAdapter;

import java.util.ArrayList;



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
        View v = inflater.inflate(R.layout.fragment_article_search, container, false);

        ArrayList<Article> articleList = new ArrayList<>();


        RecyclerView recyclerView = v.findViewById(R.id.article_search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArticleSearchAdapter adapter = new ArticleSearchAdapter(articleList, recyclerView);
        recyclerView.setAdapter(adapter);

        return v;
    }

}
