package com.example.gsonjsonapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGrabber {

    private RequestQueue mQueue;

    public static Map<String, SportsTeam> ITEM_MAP = null;

    public static List<SportsTeam> TEAMS = null;

    public void getThatDataFromThatURL (Context context){
        if (TEAMS != null){
            return;
        }

        mQueue = Volley.newRequestQueue(context);

        parseJason(context);

        TEAMS = new ArrayList<>();
        ITEM_MAP = new HashMap<>();
    }

    private void parseJason(final Context context) {
        String url = context.getString(R.string.sports_teams_url);

        final Gson gson = new Gson();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("sportsTeams");

                            if (jsonArray.length() > 0) {
                                List<SportsTeam> teams = Arrays.asList(gson.fromJson(jsonArray.toString(), SportsTeam[].class));

                                for (SportsTeam sportsTeam: teams) {
                                    addObjectToList(teams)
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
        mQueue.add(request);
    }
}
