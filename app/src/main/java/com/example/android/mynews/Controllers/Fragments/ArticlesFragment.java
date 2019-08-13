package com.example.android.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.NYTStreams;
import com.example.android.mynews.Views.ArticlesAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


public class ArticlesFragment extends Fragment {


    private Disposable disposable;
    private List<TopStoriesArticles.Result> topStoriesList;
    private ArticlesAdapter adapter;


    public ArticlesFragment() {
        // Required empty public constructor
    }


    public static ArticlesFragment newInstance() {

        return new ArticlesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_articles, container, false);

        topStoriesList = new ArrayList<>();

        RecyclerView recyclerView = v.findViewById(R.id.articles_recycler_view);
        this.adapter = new ArticlesAdapter(this.topStoriesList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        this.executeTopStoriesRequest();

        return v;
    }


    @Override
    public void onDestroy() {

        super.onDestroy();
        this.disposeWhenDestroy();
    }



    private void executeTopStoriesRequest() {

        this.disposable = NYTStreams.streamFetchTopStoriesArticles("home")
                .subscribeWith(new DisposableObserver<TopStoriesArticles>() {
                    @Override
                    public void onNext(TopStoriesArticles topStoriesArticles) {

                        Log.e("TAG", "On Next");
                        updateTopStories(topStoriesArticles);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("TAG", "On Error" + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                        Log.e("TAG", "On Complete");
                    }
                });
    }



    private void updateTopStories(TopStoriesArticles topStories) {

        List<TopStoriesArticles.Result> articles = topStories.getResults();
        this.topStoriesList.addAll(articles);

        this.adapter.notifyDataSetChanged();

        Log.e("TAG", "" + topStoriesList.size());
    }


    private void disposeWhenDestroy() {

        if (this.disposable != null && !this.disposable.isDisposed())
            this.disposable.dispose();
    }


}
