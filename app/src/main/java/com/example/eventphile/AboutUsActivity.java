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
                "events across the globe. App's landing activity is menu screen and the user can " +
                "choose one of the following options: displaying a map with event markers, a reminder " +
                "tool, the ‘About’ page, and the contact info page. We enable users to view, select and " +
                "get information about a variety of events all over the globe with ease.";
        aboutText.setText(text);
    }
}
