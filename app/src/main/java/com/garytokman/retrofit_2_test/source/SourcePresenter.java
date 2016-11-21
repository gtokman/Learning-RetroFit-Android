package com.garytokman.retrofit_2_test.source;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.SourceResponse;
import com.garytokman.retrofit_2_test.networking.NewsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class SourcePresenter {

    private final NewsService mService;
    private final SourceContract.View mView;


    public SourcePresenter(SourceContract.View articleView, NewsService service) {
        mView = articleView;
        mService = service;
    }

    public void initDataSet() {

        mService.getSourceResponse(null, "en").enqueue(new Callback<SourceResponse>() {
            @Override
            public void onResponse(Call<SourceResponse> call, Response<SourceResponse> response) {
                if (response.isSuccessful())
                {
                    mView.showSources(response.body().getSources());
                    Timber.i("Got sources from API.");
                }
            }

            @Override
            public void onFailure(Call<SourceResponse> call, Throwable t) {
                mView.showErrorMessage(t.getMessage());
                Timber.e("Error could not get data from API.");
            }
        });
    }
}
