package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.util.Strings;

import java.util.ArrayList;

import static com.example.eventphile.Global.strings;

public class FavoritesActivity extends AppCompatActivity {

    //private ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        //LinearLayout reminders = findViewById(R.id.pop);
        //reminders.removeAllViews();
        //View myChunk = getLayoutInflater().inflate(R.layout.chunk_reminders, reminders, false );

        //strings = getIntent().getStringArrayListExtra("eventName");

        TextView eventNames = findViewById(R.id.eventNames);
        //TextView date = myChunk.findViewById(R.id.date);
        //TextView time = myChunk.findViewById(R.id.time);
        String empty ="";
        for (String string : strings) {
            empty += string + "\n" + "\n";
        }
        eventNames.setText(empty);
        //eventNames.setText(eventName);
        //date.setText("");
        //time.setText("");

        //reminders.addView(myChunk);

    }
}
