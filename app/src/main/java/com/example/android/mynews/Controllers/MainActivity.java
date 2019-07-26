package com.example.android.mynews.Controllers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.mynews.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureViewPager();
    }


    private void configureViewPager() {

        ViewPager viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        TabLayout tabs = findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }


}