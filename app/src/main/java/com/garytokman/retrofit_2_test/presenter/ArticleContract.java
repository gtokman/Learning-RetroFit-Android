package com.garytokman.retrofit_2_test.presenter;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.Article;

import java.util.List;

public interface ArticleContract {

    interface View {

        void showArticles(List<Article> articles);

        void showErrorMessage(String message);

    }

}
