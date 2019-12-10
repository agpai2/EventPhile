package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

import static com.example.eventphile.Global.strings;

@SuppressWarnings("deprecation")
public class NotificationActivity extends AppCompatActivity  {

    private String name;
    private NotificationCompat.Builder builder;
    private NotificationManager manager;
    private java.util.Date date;
    //private ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView eventname = findViewById(R.id.eventName);
        //need to use intent
        name = getIntent().getStringExtra("nameCheck"); //check this again
        eventname.setText(name);


        Button favorite = findViewById(R.id.favorite);
        favorite.setOnClickListener(unused -> {
            Intent intent = new Intent(this, CalenderActivity.class);
            strings.add(name);
            //intent.putExtra("eventName", strings);
            startActivity(intent);
        });

    }


}
