package com.example.android.mynews.Controllers.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.android.mynews.Controllers.Fragments.ArticlesFragment;
import com.example.android.mynews.R;
import com.example.android.mynews.Utils.DateConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.InputType.TYPE_DATETIME_VARIATION_DATE;
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

    ArrayList<CheckBox> checkBoxList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_notification_layout);
        ButterKnife.bind(this);

        configureDatePickers();
        configureSearchButton();


    }


    // Configure DatePicker Dialogs to select begin and end dates when using Article Search
    public void configureDatePickers() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        beginDate.setInputType(TYPE_NULL);
        beginDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                        (view, year1, monthOfYear, dayOfMonth) -> beginDate.setText(dateFormat.format(new Date(year1 - 1900, monthOfYear, dayOfMonth))), year, month, day);
                datePicker.show();
            }
        });

        endDate.setInputType(TYPE_NULL);
        endDate.setOnClickListener(v -> {

            DatePickerDialog datePicker = new DatePickerDialog(v.getContext(),
                    (view, year2, monthOfYear, dayOfMonth) -> endDate.setText(dateFormat.format(new Date(year2 - 1900, monthOfYear, dayOfMonth))), year, month, day);
            datePicker.show();
        });
    }


    public ArrayList<CheckBox> createCheckboxList() {

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
    public boolean isCheckboxesChecked() {

        ArrayList<CheckBox> checkBoxes = createCheckboxList();

        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked())
                return true;
        }
        return false;
    }


    public void configureSearchButton() {

        searchButton.setOnClickListener(v -> {


            String query = searchQuery.getText().toString();
            ArrayList<String> filterQuery = new ArrayList<>();
            String beginDateConverted;
            String endDateConverted;


            // If there's at least a word typed in search field
            if (!(query.equals(""))) {

                // If there's at least one checkbox checked
                if (isCheckboxesChecked()) {

                    // Convert date format if dates are selected
                    if (beginDate != null) {
                        beginDateConverted = DateConverter.convertDatePicker(beginDate.getText().toString());
                    } else {
                        beginDateConverted = "";
                    }

                    if (endDate != null) {
                        endDateConverted = DateConverter.convertDatePicker(endDate.getText().toString());
                    } else {
                        endDateConverted = "";
                    }

                    // Add section names to a list of filter queries
                    for (CheckBox checkBox : this.checkBoxList) {
                        if (checkBox.isChecked())
                            filterQuery.add(checkBox.getTag().toString());
                        Log.d("TAG CHECKBOXES", checkBox.getTag().toString());
                    }

                    // Save search parameters and start SearchResults Activity to display results
                    Intent intent = new Intent(SearchActivity.this, SearchResultsActivity.class);
                    intent.putExtra("QUERY", query);
                    intent.putStringArrayListExtra("FILTER_QUERY", filterQuery);
                    intent.putExtra("BEGIN_DATE", beginDateConverted);
                    intent.putExtra("END_DATE", endDateConverted);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Select at least one category", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Type a query in the search field", Toast.LENGTH_SHORT).show();
            }


        });

    }

}
