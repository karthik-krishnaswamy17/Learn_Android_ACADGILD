package com.android.developer.learn_android_acadgild;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void click(View v) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true)
                .setContentTitle("Event Details")
                .setContentText("Inbox Style Notifications")
                .setSmallIcon(R.mipmap.ic_launcher);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.addLine("Hello..!");
        inboxStyle.addLine("How are You?");
        inboxStyle.addLine("HI!!!");
        inboxStyle.addLine("I am fine...");
        inboxStyle.addLine("What about you?all is well?");
        inboxStyle.addLine("Yes everything is all right...");
        builder.setStyle(inboxStyle);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }

}
