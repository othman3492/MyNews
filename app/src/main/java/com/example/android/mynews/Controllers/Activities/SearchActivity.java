package com.example.android.mynews.Controllers.Activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.android.mynews.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.InputType.TYPE_NULL;

// Activity displaying the search and notifications layout

public class SearchActivity extends AppCompatActivity {


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
    @BindView(R.id.notification_switch) Switch notificationSwitch;

    List<CheckBox> checkBoxList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureDatePickers();


    }


    // Configure DatePicker Dialogs to select begin and end dates when using Article Search
    public void configureDatePickers() {

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        beginDate.setInputType(TYPE_NULL);
        beginDate.setOnClickListener(v -> {

            DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                    (view, year1, monthOfYear, dayOfMonth) -> beginDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1), year, month, day);
            datePicker.show();
        });

        endDate.setInputType(TYPE_NULL);
        endDate.setOnClickListener(v -> {

            DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                    (view, year12, monthOfYear, dayOfMonth) -> endDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year12), year, month, day);
            datePicker.show();
        });
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
}
