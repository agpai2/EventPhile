package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

@SuppressWarnings("deprecation")
public class NotificationActivity extends AppCompatActivity {

    private String name;
    private NotificationCompat.Builder builder;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView eventname = findViewById(R.id.eventName);
        //need to use intent
        name = getIntent().getStringExtra("nameCheck"); //check this again
        eventname.setText(name);

        Button button = findViewById(R.id.addReminder);
        button.setOnClickListener(unused -> {
            notification(name);

        });
        Button setTime = findViewById(R.id.setTime);
        setTime.setOnClickListener(unused -> {
            DialogFragment timeFragment = new TimePickerFragment();
            timeFragment.show(getSupportFragmentManager(), "timePicker");
        });
        Button setDate = findViewById(R.id.setDate);
        setDate.setOnClickListener(unused -> {
            DialogFragment dateFragment = new DatePickerFragment();
            dateFragment.show(getSupportFragmentManager(), "datePicker");
        });



    }

    protected void notification(String name) {

        builder = new NotificationCompat.Builder(this, "myFoot")
                .setSmallIcon(R.drawable.appicon)
                .setContentTitle("EventPhile")
                .setContentText(name)
                .setWhen(System.currentTimeMillis() + 1000);
        Notification notification = builder.getNotification();

        Intent notifier = new Intent(this, NotificationActivity.class);
        PendingIntent contentInfo = PendingIntent.getActivity(this, 0, notifier, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentInfo);
        builder.build();
        manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1, builder.build());

    }
}
