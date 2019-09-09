package com.example.android.mynews.views;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mynews.models.Article;
import com.example.android.mynews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {


    // Interface to configure a listener on RecyclerView items
    public interface RecyclerViewOnClickListener {

        void recyclerViewOnClick(int position);
    }


    private final List<Article> articlesList;
    private final RecyclerViewOnClickListener listener;


    public ArticlesAdapter(List<Article> articlesList, RecyclerViewOnClickListener listener) {

        this.articlesList = articlesList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);

        return new ArticlesViewHolder(v, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder viewHolder, int position) {


        viewHolder.populateViewHolder(this.articlesList.get(position));
    }


    @Override
    public int getItemCount() {

        return articlesList.size();

    }


    class ArticlesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.article_image_view)
        ImageView articleImage;
        @BindView(R.id.article_category)
        TextView articleCategory;
        @BindView(R.id.article_date)
        TextView articleDate;
        @BindView(R.id.article_title)
        TextView articleTitle;

        final RecyclerViewOnClickListener recyclerViewOnClickListener;


        ArticlesViewHolder(View view, RecyclerViewOnClickListener listener) {
            super(view);
            ButterKnife.bind(this, view);
            this.recyclerViewOnClickListener = listener;
            view.setOnClickListener(this);

        }


        // Update UI with text and image data from articles
        void populateViewHolder(Article article) {

            articleCategory.setText(article.getSection());
            articleTitle.setText(article.getTitle());
            articleDate.setText(article.getDate());

            if (article.getImageUrl() != null) {
                Picasso.get().load(article.getImageUrl()).into(articleImage);
            } else {
                Picasso.get().load(R.drawable.empty_image).into(articleImage);
            }




        }

        @Override
        public void onClick(View v) {

            recyclerViewOnClickListener.recyclerViewOnClick(getAdapterPosition());

        }
    }

}

