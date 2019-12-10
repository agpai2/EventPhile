package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Button sports = findViewById(R.id.sports);
        Button music = findViewById(R.id.music);
        Button arts = findViewById(R.id.arts);
        Button family = findViewById(R.id.family);

        Typeface typeface;
        TextView textView = findViewById(R.id.textView);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/new.ttf");
        textView.setTypeface(typeface);

        Intent intent = new Intent(this, MapsActivity.class);

        sports.setOnClickListener(unused -> {
            intent.putExtra("category", "sports");
            startActivity(intent);
        });
        music.setOnClickListener(unused -> {
            intent.putExtra("category", "music");
            startActivity(intent);
        });
        arts.setOnClickListener(unused -> {
            intent.putExtra("category", "arts");
            startActivity(intent);
        });
        family.setOnClickListener(unused -> {
            intent.putExtra("category", "family");
            startActivity(intent);
        });

    }
}
