package com.garytokman.retrofit_2_test.source;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import com.garytokman.retrofit_2_test.model.Source;

import java.util.List;

public interface SourceContract {

    interface View {

        void showSources(List<Source> sources);

        void showErrorMessage(String message);

    }

}
