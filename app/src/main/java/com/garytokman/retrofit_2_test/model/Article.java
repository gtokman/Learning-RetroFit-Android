package com.garytokman.retrofit_2_test.model;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

public class Article {

    public static final String BASE_URL = "https://newsapi.org/v1/";

    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
