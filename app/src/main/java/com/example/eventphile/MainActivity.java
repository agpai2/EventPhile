package com.example.eventphile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface;
        TextView font = findViewById(R.id.font);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/new.ttf");
        font.setTypeface(typeface);
        //For all below code, should we finish or not??
        TextView title = findViewById(R.id.title);
        title.setTextColor(Color.WHITE);
        title.setBackgroundColor(Color.CYAN);


        Button eventsmap = findViewById(R.id.mapButton);
        //context must be checked
        eventsmap.setOnClickListener(unused -> {
            startActivity(new Intent(this, MapsActivity.class));
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
    }
}
