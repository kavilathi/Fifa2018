package com.example.kavi.fifaworldcup2018.model;

/**
 * Created by Kavi on 4/1/2018.
 */

public class Group {

    private String title;
    private int team1;
    private int team2;
    private int team3;
    private int team4;
    private String teamName1;
    private String teamName2;
    private String teamName3;
    private String teamName4;

    public Group(String title,int team1,int team2, int team3, int team4, String teamName1, String teamName2, String teamName3, String teamName4)
    {
        this.title=title;
        this.team1=team1;
        this.team2=team2;
        this.team3=team3;
        this.team4=team4;
        this.teamName1=teamName1;
        this.teamName2=teamName2;
        this.teamName3=teamName3;
        this.teamName3=teamName3;
        this.teamName4=teamName4;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTeam1()
    {
        return this.team1;
    }

    public int getTeam2() {
        return this.team2;
    }

    public int getTeam3() {
        return this.team3;
    }

    public int getTeam4() {
        return this.team4;
    }

    public String getTeamName1() {
        return this.teamName1;
    }

    public String getTeamName2() {
        return this.teamName2;
    }

    public String getTeamName3() {
        return this.teamName3;
    }

    public String getTeamName4() {
        return this.teamName4;
    }
}
