package com.example.kavi.fifaworldcup2018.utils;

import com.example.kavi.fifaworldcup2018.R;
import com.example.kavi.fifaworldcup2018.model.Team;
import com.example.kavi.fifaworldcup2018.model.Group;

import java.util.ArrayList;

/**
 * Created by Kavi on 3/20/2018.
 */

public class TeamList {


    public TeamList(){}

    public static ArrayList<Team> getTeamList() {

        ArrayList<Team> list_team = new ArrayList<Team>();

        list_team.add(new Team("Argentina", R.drawable.argentina,"D",1));
        list_team.add(new Team("Australia", R.drawable.australia, "C",2));
        list_team.add(new Team("Belgium", R.drawable.belgium,"G",1));
        list_team.add(new Team("Brazil", R.drawable.brazil,"E",1));
        list_team.add(new Team("Colombia", R.drawable.colombia,"H",3));
        list_team.add(new Team("Costa Rica", R.drawable.costarica,"E",3));
        list_team.add(new Team("Croatia", R.drawable.croatia,"D",3));
        list_team.add(new Team("Denmark", R.drawable.denmark,"C",4));
        list_team.add(new Team("Egypt", R.drawable.egypt, "A",3));
        list_team.add(new Team("Englang", R.drawable.england,"G",4));
        list_team.add(new Team("France", R.drawable.france,"C",1));
        list_team.add(new Team("Germany", R.drawable.germany,"F",1));
        list_team.add(new Team("Iceland", R.drawable.iceland,"D",2));
        list_team.add(new Team("Iran", R.drawable.iran, "B",4));
        list_team.add(new Team("Japan", R.drawable.japan,"H",4));
        list_team.add(new Team("Korea Republic", R.drawable.korearepublic,"F",4));
        list_team.add(new Team("Mexico", R.drawable.mexico,"F",2));
        list_team.add(new Team("Morocco", R.drawable.morocco, "B",3));
        list_team.add(new Team("Nigeria", R.drawable.nigeria,"D",4));
        list_team.add(new Team("Panama", R.drawable.panama,"G",2));
        list_team.add(new Team("Peru", R.drawable.peru,"C",3));
        list_team.add(new Team("Poland", R.drawable.poland,"G",1));
        list_team.add(new Team("Portugal", R.drawable.portugal,"B",1));
        list_team.add(new Team("Russia", R.drawable.russia, "A",1));
        list_team.add(new Team("Saudi Arabia", R.drawable.saudiarabia,"A",2));
        list_team.add(new Team("Senegal", R.drawable.senegal,"H",2));
        list_team.add(new Team("Serbia", R.drawable.serbia,"E",4));
        list_team.add(new Team("Spain", R.drawable.spain, "B",2));
        list_team.add(new Team("Sweden", R.drawable.sweden,"F",3));
        list_team.add(new Team("Switzerland", R.drawable.switzerland,"E",2));
        list_team.add(new Team("Tunisia", R.drawable.tunisia, "G",3));
        list_team.add(new Team("Uruguay", R.drawable.uruguay,"A",4));

        return list_team;
    }

    public static ArrayList<Group> getGroupList(){

        ArrayList<Group> list_group = new ArrayList<>();

        list_group.add(new Group("A",R.drawable.russia,R.drawable.saudiarabia,R.drawable.egypt,R.drawable.uruguay,"Russia","Saudi Arabia","Egypt","Uruguay"));
        list_group.add(new Group("B",R.drawable.portugal,R.drawable.spain,R.drawable.morocco,R.drawable.iran,"Portugal","Spain" ,"Morocco","Iran"));
        list_group.add(new Group("C",R.drawable.france,R.drawable.australia,R.drawable.peru,R.drawable.denmark,"France","Australia","Peru","Denmark"));
        list_group.add(new Group("D",R.drawable.argentina,R.drawable.iceland,R.drawable.croatia,R.drawable.nigeria,"Argentina","Iceland","Croatia","Nigeria"));
        list_group.add(new Group("E",R.drawable.brazil,R.drawable.switzerland,R.drawable.costarica,R.drawable.serbia,"Brazil","Switzerland","Costa Rica","Serbia"));
        list_group.add(new Group("F",R.drawable.germany,R.drawable.mexico,R.drawable.sweden,R.drawable.korearepublic,"Germany","Mexico","Sweden","Korea Republic"));
        list_group.add(new Group("G",R.drawable.belgium,R.drawable.panama,R.drawable.tunisia,R.drawable.england,"Belgium","Panama","Tunisia","England"));
        list_group.add(new Group("H",R.drawable.poland,R.drawable.senegal,R.drawable.colombia,R.drawable.japan,"Poland","Senegal","Colombia","Japan"));

        return  list_group;
    }
}
