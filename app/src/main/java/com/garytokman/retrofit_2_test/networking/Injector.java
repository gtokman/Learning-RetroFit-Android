package com.garytokman.retrofit_2_test.networking;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.BuildConfig;
import com.garytokman.retrofit_2_test.model.Article;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class Injector {

    private static Retrofit provideRetrofit(String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(provideOHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private static OkHttpClient provideOHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(provideHttpLoggingInterceptor())
                .build();
    }

    private static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Timber.d(message);
                    }
                });

        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);

        return httpLoggingInterceptor;
    }

    public static NewsService provideNewsSerivce() {

        return provideRetrofit(Article.BASE_URL).create(NewsService.class);
    }
}
