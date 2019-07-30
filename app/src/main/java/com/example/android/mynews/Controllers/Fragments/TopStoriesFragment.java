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
import com.example.android.mynews.Views.TopStoriesAdapter;

import java.util.ArrayList;



public class TopStoriesFragment extends Fragment {


    public TopStoriesFragment() {
        // Required empty public constructor
    }


    public static TopStoriesFragment newInstance() {

        return new TopStoriesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_top_stories, container, false);

        ArrayList<Article> articleList = new ArrayList<>();


        RecyclerView recyclerView = v.findViewById(R.id.top_stories_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TopStoriesAdapter adapter = new TopStoriesAdapter(articleList, recyclerView);
        recyclerView.setAdapter(adapter);

        return v;


    }

}
