package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    private String phoneText;
    private String emailText;
    private String webText;
    private String locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView phone = findViewById(R.id.phoneNumber);
        TextView email = findViewById(R.id.email);
        TextView website = findViewById(R.id.website);
        TextView location = findViewById(R.id.location);

        phoneText = "+1 (217) 111 2222";
        emailText = "eventsApp@events.com";
        webText = "https://events.com";
        locationText = "Champaign, IL";

        phone.setText(phoneText);
        email.setText(emailText);
        website.setText(webText);
        location.setText(locationText);
    }
}
