package com.example.android.mynews.controllers.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.example.android.mynews.models.Article;
import com.example.android.mynews.models.ArticleSearchArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.utils.NYTStreams;
import com.example.android.mynews.views.ArticlesAdapter;

import java.util.ArrayList;
import java.util.List;

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
    private String filterQuery;


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
    private void configureRecyclerView() {

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

        // Call the right API Search request depending on dates selected or not
        if (beginDate.length() > 0 && endDate.length() > 0) {

            this.disposable = NYTStreams.streamFetchArticleSearchWithDate(query, filterQuery, beginDate, endDate)
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
        } else {

            this.disposable = NYTStreams.streamFetchArticleSearchWithoutDate(query, filterQuery)
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
    }


    // Get all data from search queries
    private void getQueryData() {

        Intent intent = getIntent();
        query = intent.getStringExtra("QUERY");
        filterQuery = intent.getStringExtra("FILTER_QUERY");
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
    private void updateArticleList(List<Article> articlesList) {

        this.searchResultsList.addAll(articlesList);
        this.adapter.notifyDataSetChanged();
    }
}
