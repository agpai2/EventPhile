package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.media.RingtoneManager;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    /*private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView eventname = findViewById(R.id.eventName);
        //need to use intent
        name = getIntent().getStringExtra("eventname"); //check this again
        eventname.setText(name);

        Switch setNotification = findViewById(R.id.switch1);
        setNotification.setOnClickListener(unused -> {
            notification(name);
        });
    }

    protected void notification(String name) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("")
                .setContentText("")
                .setWhen()
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.build();

    }*/
}
