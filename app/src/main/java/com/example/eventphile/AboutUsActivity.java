package com.example.eventphile;

import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public final class AboutUsActivity extends AppCompatActivity {
    private String text;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView aboutText = findViewById(R.id.aboutUs);
        text = "Our App is an Android application intended for knowing about different " +
                "events across the US. The app's landing activity is the menu screen and the user can " +
                "choose one of the following options: displaying a map with event markers, an add-to-favorites " +
                "tool, the ‘About’ page, and the contact info page. The app allows users to view events and their locations, and add them to their favorites list if they like the event. ";
        aboutText.setText(text);
    }
}
