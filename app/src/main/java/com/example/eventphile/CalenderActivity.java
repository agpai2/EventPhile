package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        LinearLayout reminders = findViewById(R.id.pop);
        View myChunk = getLayoutInflater().inflate(R.layout.chunk_reminders, reminders, false );

        TextView eventNames = myChunk.findViewById(R.id.eventName);
        TextView date = myChunk.findViewById(R.id.date);
        TextView time = myChunk.findViewById(R.id.time);

        eventNames.setText("");
        date.setText("");
        time.setText("");

        reminders.addView(myChunk);

    }
}
