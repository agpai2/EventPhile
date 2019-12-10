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
public class NotificationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

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

        /*Button button = findViewById(R.id.addReminder);
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
            //java.util.Date date = getDateFromDatePicker();
        });*/

        Button favorite = findViewById(R.id.favorite);
        favorite.setOnClickListener(unused -> {
            Intent intent = new Intent(this, CalenderActivity.class);
            strings.add(name);
            //intent.putExtra("eventName", strings);
            startActivity(intent);
        });

    }

    /*protected void notification(String name) {

        builder = new NotificationCompat.Builder(this, "myFoot")
                .setSmallIcon(R.drawable.appicon)
                .setContentTitle("EventPhile")
                .setContentText(name)
                .setWhen(date.getTime());
        Notification notification = builder.getNotification();

        Intent notifier = new Intent(this, NotificationActivity.class);
        PendingIntent contentInfo = PendingIntent.getActivity(this, 0, notifier, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentInfo);
        builder.build();
        manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1, builder.build());

    }*/

    /*public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }*/

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user

        Calendar calendar = Calendar.getInstance();
        //calendar.set(Calendar.YEAR, year);
        //calendar.set(Calendar.MONTH, month);
        //calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(year, month, day);
        date = calendar.getTime();


        String dateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView = findViewById(R.id.date);
        textView.setText(dateString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user

        TextView timeString = findViewById(R.id.time);
        timeString.setText("TIME :" + hourOfDay + ":" + minute);
    }
}
