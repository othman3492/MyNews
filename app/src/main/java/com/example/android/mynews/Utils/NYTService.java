package com.example.android.mynews.Utils;



import com.example.android.mynews.Models.MostPopularArticles;
import com.example.android.mynews.Models.TopStoriesArticles;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface NYTService {


    @GET("svc/topstories/v2/{section}.json?api-key=BQGjlg67eLhEf9cBsT3V0NC8bFmoUk6q")
    Observable<List<TopStoriesArticles.Result>> getTopStories(@Path("section") String section);

    Retrofit retrofitTopStories = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();



    @GET("svc/mostpopular/v2/viewed/1.json?api-key=BQGjlg67eLhEf9cBsT3V0NC8bFmoUk6q")
    Observable<MostPopularArticles.Result> getMostPopular(@Path("section") String section);

    Retrofit retrofitMostPopular = new Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
