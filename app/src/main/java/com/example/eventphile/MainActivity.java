package com.example.eventphile;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public final class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "myFoot";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //private void createNotificationChannel() {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = getString(R.string.channel_name);
                String description = getString(R.string.channel_description);
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        //}

        Typeface typeface;
        TextView font = findViewById(R.id.font);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/new.ttf");
        font.setTypeface(typeface);
        //For all below code, should we finish or not??
        //TextView title = findViewById(R.id.title);
        //title.setTextColor(Color.WHITE);
        //title.setBackgroundColor(Color.CYAN);


        Button eventsmap = findViewById(R.id.mapButton);
        //context must be checked
        eventsmap.setOnClickListener(unused -> {
            startActivity(new Intent(this, FilterActivity.class));
            //finish or not?
        });

        Button reminder = findViewById(R.id.reminderCalendar);
        //context must be checked
        reminder.setOnClickListener(unused -> {
            startActivity(new Intent(this, CalenderActivity.class));
        });

        Button about = findViewById(R.id.aboutUs);
        //context must be checked
        about.setOnClickListener(unused -> {
            startActivity(new Intent(this, AboutUsActivity.class));
        });

        Button contact = findViewById(R.id.contact);
        //context must be checked
        contact.setOnClickListener(unused -> {
            startActivity(new Intent(this, ContactUsActivity.class));
        });

        final int[] backgroundImages = {R.drawable.event1, R.drawable.event2, R.drawable.event3, R.drawable.event4, R.drawable.event5, R.drawable.event6};
        final LinearLayout background = findViewById(R.id.mylayout);
        background.setBackgroundResource(backgroundImages[new Random().nextInt(6)]);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setBackgroundResource(backgroundImages[new Random().nextInt(6)]);
                    }
                }, 2500);
            }
        }, 0, 2500);
    }
}
