package com.example.movie.retrofit;


import com.example.movie.model.AllCategory;
import com.example.movie.model.MovieBanner;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public  interface ApiInterface {
    @GET("banner_movie.json")
    Observable<List<MovieBanner>> getAllBanners();
    @GET("{categoryId}/all_movies.json")
    Observable<List<AllCategory>> getALLCategoryMovie(@Path("categoryId") int categoryId);
}


