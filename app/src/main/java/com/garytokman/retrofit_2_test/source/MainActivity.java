package com.garytokman.retrofit_2_test.source;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.garytokman.retrofit_2_test.R;
import com.garytokman.retrofit_2_test.adapter.SourceAdapter;
import com.garytokman.retrofit_2_test.article.ArticleActivity;
import com.garytokman.retrofit_2_test.model.Source;
import com.garytokman.retrofit_2_test.networking.Injector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements SourceContract.View {

    @BindView(R.id.articleRecycler)
    RecyclerView mArticleRecycler;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private SourceAdapter mAdapter;
    private SourcePresenter mSourcePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new SourceAdapter(this, mItemListener);
        mSourcePresenter = new SourcePresenter(this, Injector.provideNewsSerivce());
        mSourcePresenter.initDataSet();

        mArticleRecycler.setLayoutManager(new LinearLayoutManager(this));
        mArticleRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showSources(List<Source> sources) {
        mProgressBar.setVisibility(View.GONE);
        for (Source source : sources) {
            mAdapter.addArticle(source);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error retrieving articles. " + message, Toast.LENGTH_SHORT).show();
    }

    private SourceAdapter.SourceItemListener mItemListener = new SourceAdapter.SourceItemListener() {
        @Override
        public void onSourceClick(String title) {
            Timber.d("The book was clicked and the title is %s", title);

            Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
            intent.putExtra(ArticleActivity.EXTRA_ID, title);
            startActivity(intent);
        }
    };
}
