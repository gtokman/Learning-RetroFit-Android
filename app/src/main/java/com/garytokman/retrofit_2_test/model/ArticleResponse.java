package com.garytokman.retrofit_2_test.model;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import java.util.List;

public class ArticleResponse {

    String status;
    String source;
    String sortBy;
    List<Article> articles;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
