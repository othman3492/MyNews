package com.example.android.mynews.Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class DateConverter {



    public static String ConvertDate(String nytDate) {

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date date = null;

        try {
            date = inputFormat.parse(nytDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputFormat.format(date);

    }




}
