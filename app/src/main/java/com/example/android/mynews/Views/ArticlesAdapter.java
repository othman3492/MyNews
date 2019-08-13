package com.example.android.mynews.Views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {


    private List<TopStoriesArticles.Result> topStoriesList;


    public ArticlesAdapter(List<TopStoriesArticles.Result> topStoriesList) {

        this.topStoriesList = topStoriesList;
    }


    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);

        return new ArticlesViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ArticlesViewHolder viewHolder, int position) {


        viewHolder.populateViewHolder(this.topStoriesList.get(position));
    }


    @Override
    public int getItemCount() {

        return topStoriesList.size();

    }


    class ArticlesViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.article_image_view)
        ImageView articleImage;
        @BindView(R.id.article_category)
        TextView articleCategory;
        @BindView(R.id.article_date)
        TextView articleDate;
        @BindView(R.id.article_title)
        TextView articleTitle;


        ArticlesViewHolder(View view) {
            super(view);
            //bindViews();
            ButterKnife.bind(this, view);

        }


        public void populateViewHolder(TopStoriesArticles.Result article) {

            articleCategory.setText(article.getSection());
            articleTitle.setText(article.getTitle());
            articleDate.setText(article.getPublishedDate());

        }


    }
}
