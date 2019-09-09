package com.example.android.mynews.controllers.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.android.mynews.R;
import com.example.android.mynews.utils.DateConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.InputType.TYPE_NULL;

// Activity displaying the article search layout

public class SearchActivity extends AppCompatActivity {


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
    @BindView(R.id.notification_switch)
    Switch notificationSwitch;

    private ArrayList<CheckBox> checkBoxList;
    private String query;
    private ArrayList<String> filterQuery;
    private String beginDateConverted;
    private String endDateConverted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureDatePickers();
        configureSearchButton();


    }


    // Configure DatePicker Dialogs to select begin and end dates when using Article Search
    private void configureDatePickers() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        beginDate.setInputType(TYPE_NULL);
        beginDate.setOnClickListener(v -> {

            DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                    (view, year1, monthOfYear, dayOfMonth) -> beginDate.setText(dateFormat.format(new Date(year1 - 1900, monthOfYear, dayOfMonth) {
                    })), year, month, day);
            datePicker.show();
        });

        endDate.setInputType(TYPE_NULL);
        endDate.setOnClickListener(v -> {

            DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                    (view, year2, monthOfYear, dayOfMonth) -> endDate.setText(dateFormat.format(new Date(year2 - 1900, monthOfYear, dayOfMonth))), year, month, day);
            datePicker.show();
        });
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


    private void configureSearchButton() {

        searchButton.setOnClickListener(v -> {


            query = searchQuery.getText().toString();
            filterQuery = new ArrayList<>();

            // If there's at least a word typed in search field
            if (!(query.isEmpty())) {

                // If there's at least one checkbox checked
                if (SearchActivity.this.isCheckboxesChecked()) {

                    // Convert date format if dates are selected
                    if (!beginDate.getText().toString().isEmpty()) {
                        beginDateConverted = DateConverter.convertDatePicker(beginDate.getText().toString());
                    } else {
                        beginDateConverted = "";
                    }

                    if (!endDate.getText().toString().isEmpty()) {
                        endDateConverted = DateConverter.convertDatePicker(endDate.getText().toString());
                    } else {
                        endDateConverted = "";
                    }

                    // Add section names to a list of filter queries
                    for (CheckBox checkBox : checkBoxList) {
                        if (checkBox.isChecked())
                            filterQuery.add(checkBox.getText().toString());
                    }

                    // Convert ArrayList to String to get request parameters
                    String fq = TextUtils.join(" ", filterQuery);

                    // Save search parameters and start SearchResults Activity to display results
                    Intent intent = new Intent(SearchActivity.this, SearchResultsActivity.class);
                    intent.putExtra("QUERY", query);
                    intent.putExtra("FILTER_QUERY", fq);
                    intent.putExtra("BEGIN_DATE", beginDateConverted);
                    intent.putExtra("END_DATE", endDateConverted);
                    SearchActivity.this.startActivity(intent);


                } else {
                    Toast.makeText(SearchActivity.this.getApplicationContext(), "Select at least one category", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(SearchActivity.this.getApplicationContext(), "Type a query in the search field", Toast.LENGTH_SHORT).show();
            }


        });

    }

}
