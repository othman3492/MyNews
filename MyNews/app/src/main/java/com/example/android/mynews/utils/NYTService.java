package com.example.android.mynews.utils;


import com.example.android.mynews.BuildConfig;
import com.example.android.mynews.models.ArticleSearchArticles;
import com.example.android.mynews.models.MostPopularArticles;
import com.example.android.mynews.models.TopStoriesArticles;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



// Make HTTP requests on New York Times API

interface NYTService {



    String API_KEY = BuildConfig.NewYorkTimesApiKey;


    // Top Stories API request
    @GET("svc/topstories/v2/{section}.json?api-key=" + API_KEY)
    Observable<TopStoriesArticles> getTopStories(@Path("section") String section);

    Retrofit retrofitTopStories = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    // Most Popular API request
    @GET("svc/mostpopular/v2/viewed/{period}.json?api-key=" + API_KEY)
    Observable<MostPopularArticles> getMostPopular(@Path("period") int period);

    Retrofit retrofitMostPopular = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    // Article Search API request with date
    @GET("svc/search/v2/articlesearch.json?api-key=" + API_KEY)
    Observable<ArticleSearchArticles> getArticleSearchWithDate(@Query("q") String query,
                                                       @Query("fq") String filterQuery,
                                                       @Query("begin_date") String beginDate,
                                                       @Query("end_date") String endDate);

    Retrofit retrofitArticleSearchWithDate = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    // Article Search API request without date
    @GET("svc/search/v2/articlesearch.json?api-key=" + API_KEY)
    Observable<ArticleSearchArticles> getArticleSearchWithoutDate(@Query("q") String query,
                                                                  @Query("fq") String filterQuery);

    Retrofit retrofitArticleSearchWithoutDate = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
