package com.example.android.mynews.Controllers.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mynews.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class NotificationsActivity extends AppCompatActivity {


    @BindView(R.id.search_edit_text) EditText searchQuery;
    @BindView(R.id.begin_date) EditText beginDate;
    @BindView(R.id.end_date) EditText endDate;
    @BindView(R.id.automobiles_checkbox) CheckBox automobilesCheckbox;
    @BindView(R.id.business_checkbox) CheckBox businessCheckbox;
    @BindView(R.id.national_checkbox) CheckBox nationalCheckbox;
    @BindView(R.id.politics_checkbox) CheckBox politicsCheckbox;
    @BindView(R.id.science_checkbox) CheckBox scienceCheckbox;
    @BindView(R.id.sports_checkbox) CheckBox sportsCheckbox;
    @BindView(R.id.technology_checkbox) CheckBox technologyCheckbox;
    @BindView(R.id.world_checkbox) CheckBox worldCheckbox;
    @BindView(R.id.search_button) Button searchButton;
    @BindView(R.id.notification_text_view) TextView notificationsTextView;
    @BindView(R.id.notification_switch) Switch notificationSwitch;

    List<CheckBox> checkBoxList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureNotificationLayout();
        configureSwitch();


    }

    // Configure NotificationActivity layout by adding or removing views different from SearchActivity layout
    public void configureNotificationLayout() {

        beginDate.setVisibility(View.GONE);
        endDate.setVisibility(View.GONE);
        searchButton.setVisibility(View.GONE);
        notificationsTextView.setVisibility(View.VISIBLE);
        notificationSwitch.setVisibility(View.VISIBLE);

    }


    // Create a list of checkboxes to verify if at least one is checked
    public boolean isCheckboxesChecked() {

        checkBoxList = new ArrayList<>();

        checkBoxList.add(automobilesCheckbox);
        checkBoxList.add(businessCheckbox);
        checkBoxList.add(nationalCheckbox);
        checkBoxList.add(politicsCheckbox);
        checkBoxList.add(scienceCheckbox);
        checkBoxList.add(sportsCheckbox);
        checkBoxList.add(technologyCheckbox);
        checkBoxList.add(worldCheckbox);

        for (CheckBox checkBox : checkBoxList) {
            if (checkBox.isChecked())
                return true;
        }
        return false;
    }


    // Configure notifications switch to alert user when query field is empty or no checkboxes are checked
    public void configureSwitch() {

        notificationSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                if (!(searchQuery.getText().toString().equals(""))) {
                    if (!isCheckboxesChecked()) {
                        Toast.makeText(getApplicationContext(), "Select at least one category", Toast.LENGTH_SHORT).show();
                        buttonView.setChecked(false);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Type a query in the search field", Toast.LENGTH_SHORT).show();
                    buttonView.setChecked(false);
                }
            }
        });
    }
}
