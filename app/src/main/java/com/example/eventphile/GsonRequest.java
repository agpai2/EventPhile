package com.example.eventphile;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

public class GsonRequest<JsonElement> extends Request<com.google.gson.JsonElement> {
    private final Gson gson = new Gson();
    //private final Class<T> clazz;
    private final Map<String, String> headers;
    private final com.android.volley.Response.Listener<com.google.gson.JsonElement> listener;
    private static JsonParser jsonParser = new JsonParser();
    private static final String TAG = "GsonRequest";

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url URL of the request to make
     * //@param clazz Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonRequest(String url, Map<String, String> headers,
                       com.android.volley.Response.Listener<com.google.gson.JsonElement> listener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        //this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;

        com.android.volley.Response.Listener<com.google.gson.JsonElement> serverResponseListener = jsonobjectResponse -> {
            if (jsonobjectResponse == null) {
                Log.i(TAG, "Delivering empty response from " + url);
                listener.onResponse(null);
            } else {
                Log.i(TAG, "Delivering parsed response from " + url);
                listener.onResponse((JsonObject) jsonParser.parse(String.valueOf(jsonobjectResponse)).getAsJsonObject());
            }
        };
        Response.ErrorListener serverErrorListener = error -> {
            if (error.networkResponse != null && error.networkResponse.data != null
                    && error.networkResponse.statusCode == HTTP_BAD_REQUEST) {
                String responseData = new String(error.networkResponse.data);
                try {
                    JsonObject errObject = jsonParser.parse(responseData).getAsJsonObject();
                    Log.i(TAG, "Delivering application-level error from " + url);
                    errorListener.onErrorResponse(new VolleyError(errObject.get("error").getAsString()));
                } catch (Exception e) {
                    Log.i(TAG, "Delivering 400 error from " + url);
                    errorListener.onErrorResponse(error);
                }
            } else {
                Log.i(TAG, "Delivering Volley error response from " + url);
                errorListener.onErrorResponse(error);
            }
        };
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(com.google.gson.JsonElement response) {
        listener.onResponse(response);
    }

    @Override
    protected com.android.volley.Response<com.google.gson.JsonElement> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return com.android.volley.Response.success(
                    jsonParser.parse(json).getAsJsonObject(),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return com.android.volley.Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return com.android.volley.Response.error(new ParseError(e));
        }
    }
}