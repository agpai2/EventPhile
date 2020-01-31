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

public class CalenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        TextView eventNames = findViewById(R.id.eventNames);

        String empty = "";
        for (String string : strings) {
            empty += string + "\n" + "\n";
        }
        eventNames.setText(empty);


    }
}
