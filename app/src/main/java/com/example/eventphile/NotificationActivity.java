package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView eventname = findViewById(R.id.eventName);
        //need to use intent
        name = getIntent().getStringExtra("nameCheck"); //check this again
        eventname.setText(name);

        Switch setNotification = findViewById(R.id.switch1);
        setNotification.setOnClickListener((View unused) -> {
            notification(name);
        });
    }

    protected void notification(String name) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("EventPhile")
                .setContentText(name)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        Intent notifier = new Intent(Intent.ACTION_VIEW);
        PendingIntent contentInfo = PendingIntent.getActivity(this, 0, notifier, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentInfo);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());

    }
}
