package com.garytokman.retrofit_2_test.article;
// Gary Tokman
// 11/20/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.ArticleResponse;
import com.garytokman.retrofit_2_test.networking.NewsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ArticlePresenter {

    private ArticleContract.View mView;
    private NewsService mNewsService;

    public ArticlePresenter(ArticleContract.View view, NewsService newsService) {
        mView = view;
        mNewsService = newsService;
    }

    public void retrieveArticle(String id) {
        mView.showProgessBar();
        mNewsService.getArticleResponse(id, "6bac43a15cfd4f309f73ec5874562c76")
                .enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if (response.isSuccessful())
                {
                    mView.hideProgressBar();
                    mView.showArticle(response.body().getArticles().get(0));
                    Timber.i("Got an article from API.");

                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                mView.showErrorMessage(t.getLocalizedMessage());
                Timber.e("Error getting article from the API.");
            }
        });
    }

}
