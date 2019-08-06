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
import com.example.android.mynews.Views.MostPopularAdapter;
import com.example.android.mynews.Views.TopStoriesAdapter;

import java.util.ArrayList;



public class MostPopularFragment extends Fragment {


    public MostPopularFragment() {
        // Required empty public constructor
    }


    public static MostPopularFragment newInstance() {

        return new MostPopularFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_most_popular, container, false);

        ArrayList<Article> articleList = new ArrayList<>();


        RecyclerView recyclerView = v.findViewById(R.id.most_popular_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MostPopularAdapter adapter = new MostPopularAdapter(articleList, recyclerView);
        recyclerView.setAdapter(adapter);

        return v;
    }

}
