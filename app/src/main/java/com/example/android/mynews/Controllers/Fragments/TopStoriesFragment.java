package com.example.android.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.NYTService;
import com.example.android.mynews.Utils.NYTStreams;
import com.example.android.mynews.Views.TopStoriesAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;


public class TopStoriesFragment extends Fragment {


    private Disposable disposable;
    private TextView textViewTest;
    private List<TopStoriesArticles.Result> topStoriesArticles;


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
        View v = inflater.inflate(R.layout.fragment_test, container, false);

        textViewTest = v.findViewById(R.id.text_view_test);


        /*RecyclerView recyclerView = v.findViewById(R.id.top_stories_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TopStoriesAdapter adapter = new TopStoriesAdapter(topStoriesArticles);
        recyclerView.setAdapter(adapter);*/

        submit(textViewTest);

        return v;
    }


    @Override
    public void onDestroy() {

        super.onDestroy();
        this.disposeWhenDestroy();
    }


    public void submit(View v) {

        this.executeHTTPRequestWithRetrofit();
    }


    private void executeHTTPRequestWithRetrofit() {

        this.disposable = NYTStreams.streamFetchTopStoriesArticles("section")
                .subscribeWith(new DisposableObserver<List<TopStoriesArticles.Result>>() {
                    @Override
                    public void onNext(List<TopStoriesArticles.Result> topStoriesArticles) {

                        Log.e("TAG", "On Next");
                        updateUIWithListOfArticles(topStoriesArticles);
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



    private void updateUIWithListOfArticles(List<TopStoriesArticles.Result> articles) {

        StringBuilder stringBuilder = new StringBuilder();

        for (TopStoriesArticles.Result article : articles) {
            stringBuilder.append(article);
        }
    }


    private void disposeWhenDestroy() {

        if (this.disposable != null && !this.disposable.isDisposed())
            this.disposable.dispose();
    }


}
