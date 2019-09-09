package com.example.android.mynews.utils;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.android.mynews.controllers.activities.NotificationsActivity;
import com.example.android.mynews.models.ArticleSearchArticles;
import com.example.android.mynews.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class NotificationReceiver extends BroadcastReceiver {

    private Context context;
    private Disposable disposable;
    private String query;
    private String fq;
    private int nbResults;


    @Override
    public void onReceive(Context context, Intent intent) {

        // Execute API request after getting queries from Notification Activity
        executeArticleSearchRequest(intent);

    }

    // Create the notification to display the number of results from the API request
    private void createNotification(Context context) {


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent notificationIntent = new Intent(context, NotificationsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Configure Notification Channel if API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CHANNEL";
            String description = "CHANNEL DESCRIPTION";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("NewsChannel", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "NewsChannel")
                    .setSmallIcon(R.drawable.baseline_notifications_white_24)
                    .setContentTitle("MyNews")
                    .setContentText(query + " : " + nbResults + " results found")
                    .setSound(alarmSound)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            if (notificationManager != null) {
                notificationManager.notify(1, notificationBuilder.build());
            }

        } else {

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "NewsChannel")
                    .setSmallIcon(R.drawable.baseline_notifications_white_24)
                    .setContentTitle("MyNews")
                    .setContentText(query + " : " + nbResults + " results found")
                    .setSound(alarmSound)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManager notificationManager2 = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager2 != null) {
                notificationManager2.notify(1, notificationBuilder.build());
            }

        }

    }



    // Execute Article Search API request and retrieve the number of corresponding articles to show in the notification
    private void executeArticleSearchRequest(Intent intent) {

        query = intent.getStringExtra("QUERY");
        fq = intent.getStringExtra("FILTER_QUERY");

        this.disposable = NYTStreams.streamFetchArticleSearchWithDate(query, fq, setCurrentDate(), setCurrentDate())
                .subscribeWith(new DisposableObserver<ArticleSearchArticles>() {
                    @Override
                    public void onNext(ArticleSearchArticles articleSearchArticles) {

                        Log.e("TAG", "On Next");
                        setNbResults(articleSearchArticles.getResponse().getDocs().size());
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("TAG", "On Error" + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                        Log.e("TAG", "On Complete");
                        createNotification(context);
                    }
                });
    }


    private void setNbResults(int nbResults) {

        this.nbResults = nbResults;
    }


    private String setCurrentDate() {

        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        return dateFormat.format(Calendar.getInstance().getTime());

    }

}

