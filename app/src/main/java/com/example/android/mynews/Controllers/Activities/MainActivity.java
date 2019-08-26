package com.example.android.mynews.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.example.android.mynews.Views.ArticlesAdapter;
import com.example.android.mynews.Views.PageAdapter;
import com.example.android.mynews.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private Toolbar mainToolbar;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Update UI
        this.configureViewPager();
        this.configureToolbar();
        this.configureDrawerLayout();
        this.configureNavigationView();
    }


    // Configure menu in the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        return true;
    }

    // Set buttons in the toolbar menu
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_activity_main_search :
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_activity_main_notifications :
                Intent intent2 = new Intent(MainActivity.this, NotificationsActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Set a back button in the toolbar
    private void OnBackPressed() {

        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Configure items in the Navigation Drawer to open the corresponding tabs
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.activity_main_drawer_world:
                viewPager.setCurrentItem(2);
                break;
            case R.id.activity_main_drawer_politics:
                viewPager.setCurrentItem(3);
                break;
            case R.id.activity_main_drawer_national:
                viewPager.setCurrentItem(4);
                break;
            case R.id.activity_main_drawer_business:
                viewPager.setCurrentItem(5);
                break;
            case R.id.activity_main_drawer_sports:
                viewPager.setCurrentItem(6);
                break;
            case R.id.activity_main_drawer_technology:
                viewPager.setCurrentItem(7);
                break;
            case R.id.activity_main_drawer_science:
                viewPager.setCurrentItem(8);
                break;
            case R.id.activity_main_drawer_automobiles:
                viewPager.setCurrentItem(9);
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


    private void configureViewPager() {

        viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

        TabLayout tabs = findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void configureToolbar() {

        mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
    }

    private void configureDrawerLayout() {
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView() {
        NavigationView navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

}