package com.example.android.mynews.Views;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.Models.Article;
import com.example.android.mynews.R;

import java.util.ArrayList;


public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    private final ArrayList<Article> articleList;
    private final RecyclerView recyclerView;


    public MostPopularAdapter(ArrayList<Article> articleList, RecyclerView recyclerView) {
        this.articleList = articleList;
        this.recyclerView = recyclerView;
    }

    @Override
    public MostPopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int height = recyclerView.getHeight() / 5;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        ConstraintLayout constraintLayout = v.findViewById(R.id.article_constraint_layout);

        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.height = height;
        constraintLayout.setLayoutParams(layoutParams);

        return new MostPopularViewHolder(v);
        
    }



    @Override
    public void onBindViewHolder(MostPopularViewHolder viewHolder, int position) {

    }


    @Override
    public int getItemCount() {
        return articleList.size();
    }





    class MostPopularViewHolder extends RecyclerView.ViewHolder {


        MostPopularViewHolder(View view) {
            super(view);


        }
    }
}