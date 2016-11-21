package com.garytokman.retrofit_2_test.article;
// Gary Tokman
// 11/20/16
// RetroFit-2-Test

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.garytokman.retrofit_2_test.R;
import com.garytokman.retrofit_2_test.model.Article;
import com.garytokman.retrofit_2_test.networking.Injector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends AppCompatActivity implements ArticleContract.View {

    public static final String EXTRA_ID = "EXTRA_SOURCE_ID";

    @BindView(R.id.titleText)
    TextView mTitleText;
    @BindView(R.id.authorText)
    TextView mAuthorText;
    @BindView(R.id.descriptionText)
    TextView mDescriptionText;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private ArticlePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_layout);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mPresenter = new ArticlePresenter(this, Injector.provideNewsSerivce());
        mPresenter.retrieveArticle(intent.getStringExtra(EXTRA_ID));

    }

    @Override
    public void showArticle(Article article) {
        mAuthorText.setText(article.getAuthor());
        mTitleText.setText(article.getTitle());
        mDescriptionText.setText(article.getDescription());
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error getting the article." + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgessBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
