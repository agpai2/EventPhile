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


        Typeface typeface;
        TextView font = findViewById(R.id.font);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/new.ttf");
        font.setTypeface(typeface);


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
                }, 2000);
            }
        }, 0, 2000);
    }
}
