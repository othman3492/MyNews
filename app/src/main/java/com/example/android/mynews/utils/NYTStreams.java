package com.example.android.mynews.utils;

import com.example.android.mynews.models.ArticleSearchArticles;
import com.example.android.mynews.models.MostPopularArticles;
import com.example.android.mynews.models.TopStoriesArticles;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



// Make HTTP requests on New York Times API

public class NYTStreams {

    
    public static Observable<TopStoriesArticles> streamFetchTopStoriesArticles(String section) {

        NYTService nytService = NYTService.retrofitTopStories.create(NYTService.class);

        return nytService.getTopStories(section)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


    public static Observable<MostPopularArticles> streamFetchMostPopularArticles(int period) {

        NYTService nytService = NYTService.retrofitMostPopular.create(NYTService.class);

        return nytService.getMostPopular(period)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


    public static Observable<ArticleSearchArticles> streamFetchArticleSearchWithDate(String query, String filterQuery,
                                                                                     String beginDate, String endDate) {

        NYTService nytService = NYTService.retrofitArticleSearchWithDate.create(NYTService.class);

        return nytService.getArticleSearchWithDate(query, filterQuery, beginDate, endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


    public static Observable<ArticleSearchArticles> streamFetchArticleSearchWithoutDate(String query, String filterQuery) {

        NYTService nytService = NYTService.retrofitArticleSearchWithoutDate.create(NYTService.class);

        return nytService.getArticleSearchWithoutDate(query, filterQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


}
