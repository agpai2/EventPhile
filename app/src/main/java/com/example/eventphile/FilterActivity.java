package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {


    //Activity corresponding to the intermediate screen- displayed once a user clicks on "Events Map" button, but
    //before the map is displayed.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        //defining button variables
        Button sports = findViewById(R.id.sports);
        Button music = findViewById(R.id.music);
        Button arts = findViewById(R.id.arts);
        Button family = findViewById(R.id.family);

        //setting the font
        Typeface typeface;
        TextView textView = findViewById(R.id.textView);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/new.ttf");
        textView.setTypeface(typeface);


        //defining what clicking each of the buttons does.
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
