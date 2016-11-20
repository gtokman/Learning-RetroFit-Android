package com.garytokman.retrofit_2_test.adapter;
// Gary Tokman
// 11/19/16
// RetroFit-2-Test

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.garytokman.retrofit_2_test.R;
import com.garytokman.retrofit_2_test.model.Article;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {

    private List<Article> mArticles;
    private Context mContext;

    public ArticleAdapter(Context context) {
        mContext = context;
        mArticles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        mArticles.add(article);
        notifyDataSetChanged();
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);

        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        Article article = mArticles.get(position);

        holder.mAuthorText.setText(article.getAuthor());
        holder.mTitleText.setText(article.getTitle());
        Glide.with(mContext)
                .load(article.getUrlToImage())
                .placeholder(R.drawable.ic_cloud_download_black_48dp)
                .error(R.drawable.ic_error_black_48dp)
                .override(48, 48)
                .centerCrop()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.titleText)
        TextView mTitleText;
        @BindView(R.id.authorText)
        TextView mAuthorText;

        public ArticleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
