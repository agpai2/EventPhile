package com.example.eventphile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.transform.ErrorListener;

import static com.android.volley.Response.*;

//import org.json.JSONObject;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private double latitude;

    private double longitude;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        sendRequest();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng uiuc = new LatLng(40.110558, -88.228333);

        mMap.addMarker(new MarkerOptions().position(uiuc).title("Marker in UIUC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uiuc));

    }

    public void sendRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=AkeZFRuRBawqRsmDWUG8KBOAm2lRGHGk&locale=*";

        GsonRequest<JsonElement> request = new GsonRequest<JsonElement>(url, null,  response ->  {

                JsonObject object = response.getAsJsonObject();
                Log.i("MapsActivity", "Hey, hey, hey!!!" + object.toString());
                JsonObject embedded = object.get("_embedded").getAsJsonObject();
                JsonArray events = embedded.get("events").getAsJsonArray();
                Log.i("MapsActivity", "Hello");
                for (JsonElement event : events) {
                    JsonObject b = event.getAsJsonObject();
                    String name = b.get("name").getAsString();
                    JsonArray classifications = b.get("classifications").getAsJsonArray();
                    for (JsonElement classification : classifications) {
                        JsonObject c = classification.getAsJsonObject();
                        JsonObject segment = c.get("segment").getAsJsonObject();
                        String category = segment.get("name").getAsString();
                    }
                    JsonObject embedded1 = b.get("_embedded").getAsJsonObject();
                    JsonArray venues = embedded1.get("venues").getAsJsonArray();
                    for (JsonElement venue : venues) {
                        JsonObject d = venue.getAsJsonObject();
                        JsonObject location = d.get("location").getAsJsonObject();
                        latitude = location.get("latitude").getAsDouble();
                        longitude = location.get("longitude").getAsDouble();

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(latitude, longitude))
                                .title(name));
                    }

                }
        }, error ->  {
                Log.i("MapsActivity", error.toString());
        });
        queue.add(request);
    }


    private Response.Listener<JsonObject> createResponseListener() {
        return new Response.Listener<JsonObject>() {
            @Override
            public void onResponse(JsonObject response) {
                Log.i("MapsActivity", "Hey, hey, hey!!!");

                //JsonObject object = response;
                JsonElement embedded = response.get("_embedded").getAsJsonObject();
                JsonArray events = embedded.getAsJsonArray();
                for (JsonElement event : events) {
                    JsonObject b = event.getAsJsonObject();
                    String name = b.get("name").getAsString();
                    JsonArray classifications = b.get("classifications").getAsJsonArray();
                    for (JsonElement classification : classifications) {
                        JsonObject c = classification.getAsJsonObject();
                        JsonObject segment = c.get("segment").getAsJsonObject();
                        String category = segment.get("name").getAsString();
                    }
                    JsonObject embedded1 = b.get("_embedded").getAsJsonObject();
                    JsonArray venues = embedded1.get("venues").getAsJsonArray();
                    for (JsonElement venue : venues) {
                        JsonObject d = venue.getAsJsonObject();
                        JsonObject location = d.get("location").getAsJsonObject();
                        latitude = location.get("latitude").getAsDouble();
                        longitude = location.get("Longitude").getAsDouble();
                        System.out.println(latitude);
                        System.out.println(longitude);
                        System.out.println(" ");
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(latitude, longitude))
                                .title(name));
                    }

                }
            }


        };
    }

    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }
}
