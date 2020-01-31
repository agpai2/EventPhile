package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    private String phoneText;

    private String emailText;

    private String webText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView phone = findViewById(R.id.phoneNumber);
        TextView email = findViewById(R.id.email);
        TextView website = findViewById(R.id.website);
        TextView location = findViewById(R.id.location);

        phoneText = "+1 (217) 819 8923";
        emailText = "aniruddh.g.pai@gmail.com";
        webText = "https://www.ticketmaster.com";

        phone.setText(phoneText);
        Linkify.addLinks(phone, Linkify.ALL);

        email.setText(emailText);
        Linkify.addLinks(email, Linkify.ALL);

        website.setText(webText);
        Linkify.addLinks(website, Linkify.ALL);

        location.setText(Html.fromHtml("<a href='https://www.google.com/maps/place/Champaign,+IL/@40.11461,-88.3471495,12z/data=!3m1!4b1!4m5!3m4!1s0x880cd08dde97691b:0x30f57847b475bfcf!8m2!3d40.1164204!4d-88.2433829'>Champaign, IL</a>"));
        location.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
