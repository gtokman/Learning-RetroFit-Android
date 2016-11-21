package com.garytokman.retrofit_2_test.networking;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.ArticleResponse;
import com.garytokman.retrofit_2_test.model.SourceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("sources")
    Call<SourceResponse>
    getSourceResponse(@Query(value = "category", encoded = true) String category, @Query("language") String language);

    @GET("articles")
    Call<ArticleResponse>
    getArticleResponse(@Query(value = "source", encoded = true) String source, @Query("apiKey") String apiKey);
}
