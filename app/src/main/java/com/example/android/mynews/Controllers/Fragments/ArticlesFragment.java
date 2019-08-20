package com.example.android.mynews.Controllers.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Controllers.Activities.ArticleActivity;
import com.example.android.mynews.Models.Article;
import com.example.android.mynews.Models.ArticleSearchArticles;
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


    private int page;
    private Disposable disposable;
    private List<Article> articlesList;
    private ArticlesAdapter adapter;


    public ArticlesFragment() {


    }


    public static ArticlesFragment newInstance(int page) {

        ArticlesFragment fragment = new ArticlesFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("PAGE", page);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_articles, container, false);

        assert getArguments() != null;
        this.page = getArguments().getInt("PAGE");

        this.articlesList = new ArrayList<>();
        displayPage();

        RecyclerView recyclerView = v.findViewById(R.id.articles_recycler_view);
        this.adapter = new ArticlesAdapter(this.articlesList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




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


    /*private void executeArticleSearchRequest() {

        this.disposable = NYTStreams.streamFetchArticleSearchArticles( , "20190801", "20190819")
                .subscribeWith(new DisposableObserver<ArticleSearchArticles>() {
                    @Override
                    public void onNext(ArticleSearchArticles articleSearchArticles) {

                        Log.e("TAG", "On Next");
                        createArticleSearchList(articleSearchArticles.getResponse().getDocs());
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
    }*/


    private List<Article> createTopStoriesList(List<TopStoriesArticles.Result> topStoriesList) {

        List<Article> articleList = new ArrayList<>();

        for (TopStoriesArticles.Result result : topStoriesList) {

            Article article = new Article().createArticleFromTopStories(result);
            articleList.add(article);
        }

        return articleList;

    }


    private List<Article> createMostPopularList(List<MostPopularArticles.Result> mostPopularList) {

        List<Article> articleList = new ArrayList<>();

        for (MostPopularArticles.Result result : mostPopularList) {

            Article article = new Article().createArticleFromMostPopular(result);
            articleList.add(article);
        }

        return articleList;
    }


    private List<Article> createArticleSearchList(List<ArticleSearchArticles.Doc> articleSearchList) {

        List<Article> articleList = new ArrayList<>();

        for (ArticleSearchArticles.Doc result : articleSearchList) {

            Article article = new Article().createArticleFromArticleSearch(result);
            articleList.add(article);
        }

        return articleList;
    }


    private void updateArticleList(List<Article> articlesList) {

        this.articlesList.addAll(articlesList);
        this.adapter.notifyDataSetChanged();
    }


    private void displayPage() {

        switch (page) {
            case 0 :
                executeTopStoriesRequest();
                break;
            case 1 :
                executeMostPopularRequest();
                break;
            default :
                executeTopStoriesRequest();
                break;
        }
    }


    private void disposeWhenDestroy() {

        if (this.disposable != null && !this.disposable.isDisposed())
            this.disposable.dispose();
    }


    @Override
    public void recyclerViewOnClick(int position) {

        Intent intent = new Intent (getActivity(), ArticleActivity.class);
        String url = articlesList.get(position).getUrl();
        intent.putExtra("URL", url);
        startActivity(intent);
    }
}
