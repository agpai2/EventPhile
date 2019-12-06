package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
        //emailText = "eventsApp@events.com";
        //webText = "https://www.ticketmaster.com";
        locationText = "Champaign, IL";

        phone.setText(phoneText);

        email.setText(Html.fromHtml("<a href=mailto: aniruddh.g.pai@gmail.com>aniruddh.g.pai@gmail.com</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());

        website.setText(Html.fromHtml("<a href='https://www.ticketmaster.com'>https://www.ticketmaster.com</a>"));
        website.setMovementMethod(LinkMovementMethod.getInstance());

        location.setText(locationText);
    }
}
