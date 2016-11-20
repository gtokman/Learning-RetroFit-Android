package com.garytokman.retrofit_2_test.networking;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleService {
    @GET("articles")
    Call<ArticleResponse>
    getArticleResponse(@Query(value = "source") String source, @Query("apiKey") String apiKey);
}
