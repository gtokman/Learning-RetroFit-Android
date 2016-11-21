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
import com.garytokman.retrofit_2_test.model.Source;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.ArticleHolder> {

    public interface SourceItemListener {
        void onSourceClick(String title);
    }

    private List<Source> mSources;
    private WeakReference<Context> mContext;
    private SourceItemListener mItemListener;

    public SourceAdapter(Context context, SourceItemListener itemListener) {
        mContext = new WeakReference<>(context);
        mSources = new ArrayList<>();
        mItemListener = itemListener;
    }

    public void addArticle(Source source) {
        mSources.add(source);
        notifyDataSetChanged();
    }

    public Source getItem(int adapterPosition) {
        return mSources.get(adapterPosition);
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);

        return new ArticleHolder(view, mItemListener);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        Source source = mSources.get(position);

        holder.mSourceName.setText(source.getName());
        holder.mSourceDesc.setText(source.getDescription());
        Glide.with(mContext.get())
                .load(source.getUrlsToLogos().getSmall())
                .placeholder(R.drawable.ic_cloud_download_black_48dp)
                .error(R.drawable.ic_error_black_48dp)
                .override(48, 48)
                .centerCrop()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mSources.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView)
        ImageView mImageView;
        @BindView(R.id.sourceName)
        TextView mSourceName;
        @BindView(R.id.descriptionText)
        TextView mSourceDesc;

        private SourceItemListener mItemListener;

        public ArticleHolder(View itemView, SourceItemListener itemListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mItemListener = itemListener;
        }

        @Override
        public void onClick(View view) {
            Source source = getItem(getAdapterPosition());

            mItemListener.onSourceClick(source.getId());
        }
    }
}
