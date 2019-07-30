package com.example.android.mynews.Views;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.R;

import java.util.ArrayList;


public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {

    private final ArrayList<Article> articleList;
    private final RecyclerView recyclerView;


    public TopStoriesAdapter(ArrayList<Article> articleList, RecyclerView recyclerView) {
        this.articleList = articleList;
        this.recyclerView = recyclerView;
    }

    @Override
    public TopStoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        ConstraintLayout constraintLayout = v.findViewById(R.id.article_constraint_layout);

        return new TopStoriesViewHolder(v);
    }



    @Override
    public void onBindViewHolder(TopStoriesViewHolder viewHolder, int position) {

    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }





    class TopStoriesViewHolder extends RecyclerView.ViewHolder {


        TopStoriesViewHolder(View view) {
            super(view);


        }
    }
}
