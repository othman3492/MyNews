package com.example.android.mynews.Controllers.Activities;

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

import java.util.ArrayList;
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
    private Disposable disposable;
    private String query;
    private String fq;
    private int nbResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureNotificationLayout();
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

        query = searchQuery.getText().toString();
        ArrayList<String> filterQuery = new ArrayList<>();

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    if (!(query.equals(""))) {
                        if (!NotificationsActivity.this.isCheckboxesChecked()) {
                            Toast.makeText(NotificationsActivity.this.getApplicationContext(), "Select at least one category", Toast.LENGTH_SHORT).show();
                            buttonView.setChecked(false);
                        }

                        // Add section names to a list of filter queries
                        for (CheckBox checkBox : checkBoxList) {
                            if (checkBox.isChecked())
                                filterQuery.add(checkBox.getText().toString());
                        }

                        // Convert ArrayList to String to get request parameters
                        fq = TextUtils.join(" ", filterQuery);

                        //Execute API request and get the number of results
                        executeArticleSearchRequest();


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


        this.disposable = NYTStreams.streamFetchArticleSearchWithoutDate(query, fq)
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


    // Configure a notification to show the number of results from the API request
    private void configureNotification() {

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("MyNews")
                .setContentText(nbResults + " results found.")
                .setStyle(new NotificationCompat.BigTextStyle())
                    .bigText(nbResults + " results found.")
                .setAutoCancel(true);
    }
}
