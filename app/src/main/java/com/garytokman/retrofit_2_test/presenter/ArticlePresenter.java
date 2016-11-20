package com.garytokman.retrofit_2_test.presenter;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.ArticleResponse;
import com.garytokman.retrofit_2_test.networking.ArticleService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ArticlePresenter {

    private final ArticleService mService;
    private final ArticleContract.View mView;


    public ArticlePresenter(ArticleContract.View articleView, ArticleService service) {
        mView = articleView;
        mService = service;
    }

    public void initDataSet() {

        mService.getArticleResponse("techcrunch", "6bac43a15cfd4f309f73ec5874562c76")
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        if (response.isSuccessful()) {
                            // update ui
                            mView.showArticles(response.body().getArticles());
                            Timber.i("onResponse: Article data loaded from api.");
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        // update ui with error
                        mView.showErrorMessage(t.getLocalizedMessage());
                        Timber.e("Error getting articles form api.");
                    }
                });
    }
}
