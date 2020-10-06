package com.example.gsonjsonapp;

import com.google.gson.annotations.SerializedName;

public class SportsTeams {
    @SerializedName("name")
    public String sportsTeamName;

    @SerializedName("year")
    public int sportsTeamYearFounded;

    @SerializedName("info")
    public String sportsTeamInfo;

    public SportsTeams(String name, int year, String info)
    {
        sportsTeamName = name;
        sportsTeamYearFounded = year;
        sportsTeamInfo = info;
    }
}
