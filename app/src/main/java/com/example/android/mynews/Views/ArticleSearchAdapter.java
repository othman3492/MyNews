package com.example.android.mynews.Views;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.R;

import java.util.ArrayList;


public class ArticleSearchAdapter extends RecyclerView.Adapter<ArticleSearchAdapter.ArticleSearchViewHolder> {

    private final ArrayList<Article> articleList;
    private final RecyclerView recyclerView;


    public ArticleSearchAdapter(ArrayList<Article> articleList, RecyclerView recyclerView) {
        this.articleList = articleList;
        this.recyclerView = recyclerView;
    }

    @Override
    public ArticleSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        ConstraintLayout constraintLayout = v.findViewById(R.id.article_constraint_layout);

        return new ArticleSearchViewHolder(v);
    }



    @Override
    public void onBindViewHolder(ArticleSearchViewHolder viewHolder, int position) {

    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }




    class ArticleSearchViewHolder extends RecyclerView.ViewHolder {


        ArticleSearchViewHolder(View view) {
            super(view);


        }
    }
}