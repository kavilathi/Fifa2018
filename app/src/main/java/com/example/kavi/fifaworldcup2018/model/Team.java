package com.example.kavi.fifaworldcup2018.model;

/**
 * Created by Kavi on 3/18/2018.
 */

public class Team {

    private String mTeamName;
    private int mTeamFlag;
    private String mTeamGroup;
    private int mTeamId;


    public Team(String vTeamName,int vTeamFlag, String vTeamGroup, int vTeamId)
    {
        this.mTeamName = vTeamName;
        this.mTeamFlag = vTeamFlag;
        this.mTeamGroup =  vTeamGroup;
        this.mTeamId = vTeamId;
    }


    public String getTeamName()
    {
        return mTeamName;
    }

    public int getTeamFlag()
    {
        return mTeamFlag;
    }

    public String getTeamGroup(){return mTeamGroup;}

    public int getTeamId(){return mTeamId;}


    public void getGroupA()
    {

    }
}
