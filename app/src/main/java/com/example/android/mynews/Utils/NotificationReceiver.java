package com.example.android.mynews.Utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.android.mynews.Controllers.Activities.SearchResultsActivity;

public class NotificationReceiver extends BroadcastReceiver {

    private Context context;
    private int nbResults;


    @Override
    public void onReceive(Context context, Intent intent) {

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Create notification channel
        createNotificationChannel();

        // Create the notification to display the number of results from the API request

        Intent notificationIntent = new Intent(context, SearchResultsActivity.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, "NewsChannel")
                .setContentTitle("MyNews")
                .setContentText("example")
                .setSound(alarmSound)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }


    // Create a notification channel for API 26+
    private void createNotificationChannel() {

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
        }
    }
}

