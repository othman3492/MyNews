package com.example.android.mynews.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import com.example.android.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

// Activity displaying selected articles in a WebView

public class ArticleActivity extends AppCompatActivity {


    @BindView(R.id.article_web_view) WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ButterKnife.bind(this, this);
        webView.loadUrl(getIntent().getStringExtra("URL"));
    }
}
