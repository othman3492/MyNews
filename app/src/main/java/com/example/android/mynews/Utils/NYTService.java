package com.example.android.mynews.Utils;


import com.example.android.mynews.BuildConfig;
import com.example.android.mynews.Models.ArticleSearchArticles;
import com.example.android.mynews.Models.MostPopularArticles;
import com.example.android.mynews.Models.TopStoriesArticles;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NYTService {



    String API_KEY = BuildConfig.NewYorkTimesApiKey;


    @GET("svc/topstories/v2/{section}.json?api-key=" + API_KEY)
    Observable<TopStoriesArticles> getTopStories(@Path("section") String section);

    Retrofit retrofitTopStories = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    @GET("svc/mostpopular/v2/viewed/{period}.json?api-key=" + API_KEY)
    Observable<MostPopularArticles> getMostPopular(@Path("period") int period);

    Retrofit retrofitMostPopular = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


    @GET("svc/search/v2/articlesearch.json?api-key=" + API_KEY)
    Observable<ArticleSearchArticles> getArticleSearch(@Query("q") List<String> search,
                                                       @Query("begin_date") String beginDate,
                                                       @Query("end_date") String endDate);

    Retrofit retrofitArticleSearch = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
