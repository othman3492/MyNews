package com.example.android.mynews.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.mynews.Views.PageAdapter;
import com.example.android.mynews.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar mainToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureViewPager();
        this.configureToolbar();
        this.configureDrawerLayout();
        this.configureNavigationView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_activity_main_search :
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    private void OnBackPressed() {

        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.activity_main_drawer_1 :
                break;
            case R.id.activity_main_drawer_2 :
                break;
            case R.id.activity_main_drawer_3 :
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void configureViewPager() {

        ViewPager viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        TabLayout tabs = findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    private void configureToolbar() {

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
    }

    private void configureDrawerLayout(){
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView(){
        this.navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}