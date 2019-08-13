package com.example.android.mynews.Utils;

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


    public static Observable<MostPopularArticles> streamFetchMostPopularArticles(String section) {

        NYTService nytService = NYTService.retrofitMostPopular.create(NYTService.class);

        return nytService.getMostPopular(section)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }


}
