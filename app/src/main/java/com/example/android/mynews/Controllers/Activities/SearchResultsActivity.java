package com.example.android.mynews.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android.mynews.Controllers.Fragments.ArticlesFragment;
import com.example.android.mynews.Models.Article;
import com.example.android.mynews.Models.ArticleSearchArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.NYTStreams;
import com.example.android.mynews.Views.ArticlesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class SearchResultsActivity extends AppCompatActivity implements ArticlesAdapter.RecyclerViewOnClickListener {


    private Disposable disposable;
    private ArrayList<Article> searchResultsList;
    private ArticlesAdapter adapter;
    private String query;
    private String beginDate;
    private String endDate;
    private ArrayList<String> filterQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        configureRecyclerView();
        executeArticleSearchRequest();
    }


    @Override
    public void onDestroy() {

        super.onDestroy();
        this.disposeWhenDestroy();
    }


    // Configure RecyclerView to display articles
    public void configureRecyclerView() {

        searchResultsList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.articles_search_recycler_view);
        this.adapter = new ArticlesAdapter(this.searchResultsList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    // Start Article Activity when clicked on a RecyclerView item to display it in a WebView
    @Override
    public void recyclerViewOnClick(int position) {

        Intent intent = new Intent (SearchResultsActivity.this, ArticleActivity.class);
        String url = searchResultsList.get(position).getUrl();
        intent.putExtra("URL", url);
        startActivity(intent);
    }


    // Execute Article Search API request and retrieve an array of articles corresponding to the search query
    private void executeArticleSearchRequest() {

        getQueryData();

        this.disposable = NYTStreams.streamFetchArticleSearchArticles(query, filterQuery, beginDate, endDate)
                .subscribeWith(new DisposableObserver<ArticleSearchArticles>() {
                    @Override
                    public void onNext(ArticleSearchArticles articleSearchArticles) {

                        Log.e("TAG", "On Next");
                        updateArticleList(createArticleSearchList(articleSearchArticles.getResponse().getDocs()));
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


    private void getQueryData() {

        Intent intent = new Intent();
        query = intent.getStringExtra("QUERY");
        filterQuery = intent.getStringArrayListExtra("FILTER_QUERY");
        beginDate = intent.getStringExtra("BEGIN_DATE");
        endDate = intent.getStringExtra("END_DATE");

    }


    private void disposeWhenDestroy() {

        if (this.disposable != null && !this.disposable.isDisposed())
            this.disposable.dispose();
    }


    // Create a list a Article objects from retrieved Article Search articles results
    private List<Article> createArticleSearchList(List<ArticleSearchArticles.Doc> articleSearchList) {

        List<Article> articleList = new ArrayList<>();

        for (ArticleSearchArticles.Doc result : articleSearchList) {

            Article article = new Article().createArticleFromArticleSearch(result);
            articleList.add(article);
        }

        return articleList;
    }


    // Fill the Article list displayed in the RecyclerView with data from the API request
    public void updateArticleList(List<Article> articlesList) {

        this.searchResultsList.addAll(articlesList);
        this.adapter.notifyDataSetChanged();
    }
}
