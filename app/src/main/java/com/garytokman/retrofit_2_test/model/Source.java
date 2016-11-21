package com.garytokman.retrofit_2_test.model;
// Gary Tokman
// 11/20/16
// RetroFit-2-Test

public class Source {

    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String country;
    private UrlLogoSize urlsToLogos;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getCountry() {
        return country;
    }

    public UrlLogoSize getUrlsToLogos() {
        return urlsToLogos;
    }

    public static class UrlLogoSize {
        private String small;
        private String medium;
        private String large;

        public String getSmall() {
            return small;
        }

        public String getMedium() {
            return medium;
        }

        public String getLarge() {
            return large;
        }
    }
}
