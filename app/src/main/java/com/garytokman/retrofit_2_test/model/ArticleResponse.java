package com.garytokman.retrofit_2_test.model;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import java.util.List;

public class ArticleResponse {

    String status;
    List<Article> articles;

    public String getStatus() {
        return status;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
