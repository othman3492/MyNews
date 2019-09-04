package com.example.android.mynews.Controllers.Activities;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mynews.Models.ArticleSearchArticles;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.NYTStreams;
import com.example.android.mynews.Utils.NotificationReceiver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


// Activity displaying the notifications layout

public class NotificationsActivity extends AppCompatActivity {


    @BindView(R.id.search_edit_text)
    EditText searchQuery;
    @BindView(R.id.begin_date)
    EditText beginDate;
    @BindView(R.id.end_date)
    EditText endDate;
    @BindView(R.id.automobiles_checkbox)
    CheckBox automobilesCheckbox;
    @BindView(R.id.business_checkbox)
    CheckBox businessCheckbox;
    @BindView(R.id.national_checkbox)
    CheckBox nationalCheckbox;
    @BindView(R.id.politics_checkbox)
    CheckBox politicsCheckbox;
    @BindView(R.id.science_checkbox)
    CheckBox scienceCheckbox;
    @BindView(R.id.sports_checkbox)
    CheckBox sportsCheckbox;
    @BindView(R.id.technology_checkbox)
    CheckBox technologyCheckbox;
    @BindView(R.id.world_checkbox)
    CheckBox worldCheckbox;
    @BindView(R.id.search_button)
    Button searchButton;
    @BindView(R.id.notification_text_view)
    TextView notificationsTextView;
    @BindView(R.id.notification_switch)
    Switch notificationSwitch;

    private ArrayList<CheckBox> checkBoxList;
    private String query;
    private ArrayList<String> filterQuery;
    private String fq;
    private int nbResults;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureNotificationLayout();
        getSharedPreferences();
        //notificationTest();
        configureSwitch();


    }

    // Configure NotificationActivity layout by adding or removing views different from SearchActivity layout
    private void configureNotificationLayout() {

        beginDate.setVisibility(View.GONE);
        endDate.setVisibility(View.GONE);
        searchButton.setVisibility(View.GONE);
        notificationsTextView.setVisibility(View.VISIBLE);
        notificationSwitch.setVisibility(View.VISIBLE);

    }


    // Save search data into Shared Preferences
    private void saveSharedPreferences() {

        // Create shared preferences and save list's size
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putInt("LIST_SIZE", filterQuery.size()).apply();

        // Save query
        preferences.edit().putString("QUERY", query).apply();

        // Save all filter queries
        for (String filter : filterQuery)
            preferences.edit().putString("FILTER_QUERIES" + filterQuery.indexOf(filter), filter).apply();
    }


    // Get data from last search and display it
    private void getSharedPreferences() {

        // Get last query and put it in the search field
        searchQuery.setText(preferences.getString("QUERY", ""));

        // Get last checked checkboxes and check them
        for (CheckBox checkBox : checkBoxList) {

            String checkboxName = preferences.getString("FILTER_QUERIES" + checkBoxList.indexOf(checkBox), null);
            if (checkboxName != null && checkboxName.equals(checkBox.getText().toString()))
                checkBox.setChecked(true);
        }

    }


    private ArrayList<CheckBox> createCheckboxList() {

        checkBoxList = new ArrayList<>();

        checkBoxList.add(automobilesCheckbox);
        checkBoxList.add(businessCheckbox);
        checkBoxList.add(nationalCheckbox);
        checkBoxList.add(politicsCheckbox);
        checkBoxList.add(scienceCheckbox);
        checkBoxList.add(sportsCheckbox);
        checkBoxList.add(technologyCheckbox);
        checkBoxList.add(worldCheckbox);

        return checkBoxList;
    }


    // Create a list of checkboxes and verify if at least one is checked
    private boolean isCheckboxesChecked() {

        ArrayList<CheckBox> checkBoxes = createCheckboxList();

        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked())
                return true;
        }
        return false;
    }


    // Configure notifications switch to alert user when query field is empty or no checkboxes are checked
    private void configureSwitch() {

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                query = searchQuery.getText().toString();
                filterQuery = new ArrayList<>();

                if (isChecked) {

                    // If there's at least a word typed in search field
                    if (!(query.isEmpty())) {

                        // If there's at least one checkbox checked
                        if (isCheckboxesChecked()) {

                            // Add section names to a list of filter queries
                            for (CheckBox checkBox : checkBoxList) {
                                if (checkBox.isChecked())
                                    filterQuery.add(checkBox.getText().toString());
                            }

                            // Save data into shared preferences
                            saveSharedPreferences();

                            // Convert ArrayList to String to get request parameters
                            fq = TextUtils.join(" ", filterQuery);

                            //Configure AlarmManager to activate notifications
                            configureAlarmManager();

                            //Execute API request and get the number of results
                            executeArticleSearchRequest();

                        } else {
                            Toast.makeText(getApplicationContext(), "Select at least one category", Toast.LENGTH_SHORT).show();
                            buttonView.setChecked(false);
                        }

                    } else {
                        Toast.makeText(NotificationsActivity.this.getApplicationContext(), "Type a query in the search field", Toast.LENGTH_SHORT).show();
                        buttonView.setChecked(false);
                    }
                }
            }
        });
    }


    // Execute Article Search API request and retrieve the number of corresponding articles to show in the notification
    private void executeArticleSearchRequest() {


        Disposable disposable = NYTStreams.streamFetchArticleSearchWithoutDate(query, fq)
                .subscribeWith(new DisposableObserver<ArticleSearchArticles>() {
                    @Override
                    public void onNext(ArticleSearchArticles articleSearchArticles) {

                        Log.e("TAG", "On Next");
                        nbResults = articleSearchArticles.getResponse().getDocs().size();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("TAG", "On Error" + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                        Log.e("TAG", "On Complete");
                    }
                });
    }


    // Create the AlarmManager to plan the notification to be called every day
    private void configureAlarmManager() {

        // Set the alarm to start at noon
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);

        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        intent.putExtra("QUERY", query);
        intent.putExtra("FILTER_QUERY", fq);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }


    private void notificationTest() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CHANNEL";
            String description = "CHANNEL DESCRIPTION";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("NewsChannel", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getApplicationContext().getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "NewsChannel")
                    .setContentTitle("MyNews")
                    .setContentText("example")
                    .setAutoCancel(true);

            notificationBuilder.build();

        }

    }
