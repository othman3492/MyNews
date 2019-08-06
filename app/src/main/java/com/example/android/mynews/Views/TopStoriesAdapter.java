package com.example.android.mynews.Views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mynews.Models.TopStoriesArticles;
import com.example.android.mynews.R;
import java.util.ArrayList;
import java.util.List;


public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {


    private List<TopStoriesArticles.Result> topStoriesList;


    public TopStoriesAdapter(List<TopStoriesArticles.Result> topStoriesList) {

        this.topStoriesList= topStoriesList;
    }


    @Override
    public TopStoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);

        return new TopStoriesViewHolder(v);
    }



    @Override
    public void onBindViewHolder(TopStoriesViewHolder viewHolder, int position) {

        final TopStoriesArticles.Result article = topStoriesList.get(position);

        viewHolder.populateViewHolder(article);
    }


    @Override
    public int getItemCount() {
        return topStoriesList.size();
    }





    static class TopStoriesViewHolder extends RecyclerView.ViewHolder {

        final View articleView;
        final ImageView articleImageView;
        final TextView articleCategory;
        final TextView articleDate;
        final TextView articleContent;


        TopStoriesViewHolder(View view) {
            super(view);

            articleView = itemView.findViewById(R.id.article_view);
            articleImageView = itemView.findViewById(R.id.article_image_view);
            articleCategory = itemView.findViewById(R.id.article_category);
            articleDate = itemView.findViewById(R.id.article_date);
            articleContent = itemView.findViewById(R.id.article_title);

        }

        public void populateViewHolder(TopStoriesArticles.Result article) {

            articleContent.setText(article.getTitle());



        }
    }
}
