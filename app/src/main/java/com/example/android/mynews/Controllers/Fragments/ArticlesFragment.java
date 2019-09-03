package com.example.android.mynews.Controllers.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Controllers.Activities.ArticleActivity;
import com.example.android.mynews.Models.Article;
import com.example.android.mynews.Models.MostPopularArticles;
import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.NYTStreams;
import com.example.android.mynews.Views.ArticlesAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;



public class ArticlesFragment extends Fragment implements ArticlesAdapter.RecyclerViewOnClickListener {


    private int fragmentId;
    private Disposable disposable;
    private List<Article> articlesList;
    private ArticlesAdapter adapter;


    public ArticlesFragment() {


    }


    // Create new fragment and save its page ID
    public static ArticlesFragment newInstance(int fragmentId) {

        ArticlesFragment fragment = new ArticlesFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("ID", fragmentId);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_articles, container, false);

        // Get the fragment page ID to display corresponding data
        assert getArguments() != null;
        this.fragmentId = getArguments().getInt("ID");

        this.articlesList = new ArrayList<>();
        displayPage();
        configureRecyclerView(v);


        return v;
    }


    @Override
    public void onDestroy() {

        super.onDestroy();
        this.disposeWhenDestroy();
    }


    // Execute Top Stories API request and retrieve an array of articles from the selected section
    private void executeTopStoriesRequest(String section) {

        this.disposable = NYTStreams.streamFetchTopStoriesArticles(section)
                .subscribeWith(new DisposableObserver<TopStoriesArticles>() {
                    @Override
                    public void onNext(TopStoriesArticles topStoriesArticles) {

                        Log.e("TAG", "On Next");
                        updateArticleList(createTopStoriesList(topStoriesArticles.getResults()));
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


    // Execute Most Popular API request and retrieve an array of articles from the selected period
    private void executeMostPopularRequest() {

        this.disposable = NYTStreams.streamFetchMostPopularArticles(7)
                .subscribeWith(new DisposableObserver<MostPopularArticles>() {
                    @Override
                    public void onNext(MostPopularArticles mostPopularArticles) {

                        Log.e("TAG", "On Next");
                        updateArticleList(createMostPopularList(mostPopularArticles.getResults()));
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



    // Create a list of Article objects from retrieved Top Stories articles results
    private List<Article> createTopStoriesList(List<TopStoriesArticles.Result> topStoriesList) {

        List<Article> articleList = new ArrayList<>();

        for (TopStoriesArticles.Result result : topStoriesList) {

            Article article = new Article().createArticleFromTopStories(result);
            articleList.add(article);
        }

        return articleList;

    }


    // Create a list a Article objects from retrieved Most Popular articles results
    private List<Article> createMostPopularList(List<MostPopularArticles.Result> mostPopularList) {

        List<Article> articleList = new ArrayList<>();

        for (MostPopularArticles.Result result : mostPopularList) {

            Article article = new Article().createArticleFromMostPopular(result);
            articleList.add(article);
        }

        return articleList;
    }





    // Update fragment with data from the right API request depending on page displayed
    private void displayPage() {

        switch (fragmentId) {
            case 0 :
                executeTopStoriesRequest("home");
                break;
            case 1 :
                executeMostPopularRequest();
                break;
            case 2 :
                executeTopStoriesRequest("world");
                break;
            case 3 :
                executeTopStoriesRequest("politics");
                break;
            case 4 :
                executeTopStoriesRequest("national");
                break;
            case 5 :
                executeTopStoriesRequest("business");
                break;
            case 6 :
                executeTopStoriesRequest("sports");
                break;
            case 7 :
                executeTopStoriesRequest("technology");
                break;
            case 8 :
                executeTopStoriesRequest("science");
                break;
            case 9 :
                executeTopStoriesRequest("automobiles");
                break;
        }
    }


    private void disposeWhenDestroy() {

        if (this.disposable != null && !this.disposable.isDisposed())
            this.disposable.dispose();
    }


    // Configure RecyclerView to display articles
    private void configureRecyclerView(View v) {

        RecyclerView recyclerView = v.findViewById(R.id.articles_recycler_view);
        this.adapter = new ArticlesAdapter(this.articlesList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    // Start Article Activity when clicked on a RecyclerView item to display it in a WebView
    @Override
    public void recyclerViewOnClick(int position) {

        Intent intent = new Intent (getActivity(), ArticleActivity.class);
        String url = articlesList.get(position).getUrl();
        intent.putExtra("URL", url);
        startActivity(intent);
    }


    // Fill the Article list displayed in the RecyclerView with data from the API request
    private void updateArticleList(List<Article> articlesList) {

        this.articlesList.addAll(articlesList);
        this.adapter.notifyDataSetChanged();
    }


}
