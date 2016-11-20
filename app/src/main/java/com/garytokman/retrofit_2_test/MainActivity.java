package com.garytokman.retrofit_2_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.garytokman.retrofit_2_test.adapter.ArticleAdapter;
import com.garytokman.retrofit_2_test.model.Article;
import com.garytokman.retrofit_2_test.networking.Injector;
import com.garytokman.retrofit_2_test.presenter.ArticleContract;
import com.garytokman.retrofit_2_test.presenter.ArticlePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ArticleContract.View {

    @BindView(R.id.articleRecycler)
    RecyclerView mArticleRecycler;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private ArticleAdapter mAdapter;
    private ArticlePresenter mArticlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new ArticleAdapter(this);
        mArticlePresenter = new ArticlePresenter(this, Injector.provideArticleService());
        mArticlePresenter.initDataSet();

        mArticleRecycler.setLayoutManager(new LinearLayoutManager(this));
        mArticleRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showArticles(List<Article> articles) {
        mProgressBar.setVisibility(View.GONE);
        for (Article article : articles) {
            mAdapter.addArticle(article);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error retrieving articles. " + message, Toast.LENGTH_SHORT).show();
    }
}
