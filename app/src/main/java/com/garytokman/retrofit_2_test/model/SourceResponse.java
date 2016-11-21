package com.garytokman.retrofit_2_test.model;
// Gary Tokman
// 11/20/16
// RetroFit-2-Test

import java.util.List;

public class SourceResponse {

    private String status;
    private List<Source> sources;

    public String getStatus() {
        return status;
    }

    public List<Source> getSources() {
        return sources;
    }
}
