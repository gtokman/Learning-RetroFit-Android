package com.garytokman.retrofit_2_test;

import android.app.Application;

import timber.log.Timber;

// Gary Tokman
// 11/19/16
// RetroFit-2-Test

public class ArticleTestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        Timber.i("Creating the app!");

    }
}
