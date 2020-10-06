package com.example.gsonjsonapp;

import com.google.gson.annotations.SerializedName;

public class SportsTeam {
    @SerializedName("name")
    public String sportsTeamName;

    @SerializedName("year")
    public int sportsTeamYearFounded;

    @SerializedName("info")
    public String sportsTeamInfo;

    public String getSportsTeamName() {return sportsTeamName;}

    public int getSportsTeamYearFounded() {return sportsTeamYearFounded;}

    public String getSportsTeamInfo() {return sportsTeamInfo;}

    public SportsTeam(String name, int year, String info)
    {
        sportsTeamName = name;
        sportsTeamYearFounded = year;
        sportsTeamInfo = info;
    }
}
