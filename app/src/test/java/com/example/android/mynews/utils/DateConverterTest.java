package com.example.android.mynews.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateConverterTest {

    @Test
    public void convertDateWithSuccess() {

        String dateTest = "2019-01-01T10:10:10";
        String dateConverted = DateConverter.convertDate(dateTest);

        assertEquals(dateConverted, "2019-01-01");
    }

    @Test
    public void convertDatePickerWithSuccess() {

        String dateTest = "01/01/2019";
        String dateConverted = DateConverter.convertDatePicker(dateTest);

        assertEquals(dateConverted, "2019-01-01");
    }
}