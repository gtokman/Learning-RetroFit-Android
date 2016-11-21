package com.garytokman.retrofit_2_test.article;
// Gary Tokman
// 11/20/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.Article;

public interface ArticleContract {

    interface View {
        void showArticle(Article article);

        void showErrorMessage(String message);

        void showProgessBar();

        void hideProgressBar();
    }
}
