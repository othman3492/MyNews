package com.example.android.mynews.Utils;

import com.example.android.mynews.Models.ArticleSearchArticles;
import com.example.android.mynews.Models.MostPopularArticles;
import com.example.android.mynews.Models.TopStoriesArticles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



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


    public static Observable<ArticleSearchArticles> streamFetchArticleSearchArticles(List<String> search, String beginDate, String endDate) {

        NYTService nytService = NYTService.retrofitArticleSearch.create(NYTService.class);

        return nytService.getArticleSearch(search, beginDate, endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


}
