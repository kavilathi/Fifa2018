package com.example.kavi.fifaworldcup2018.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kavi on 3/18/2018.
 */

public class MyPref {

    Context context;
    String teamName;

    public MyPref(Context context)
    {
        this.context=context;
    }

    public void saveFavoriteTeam(String teamName)
    {
        this.teamName=teamName;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favorite team",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("team",this.teamName);
        editor.commit();
    }

    public String getSavedFavoriteTeam()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favorite team",context.MODE_PRIVATE);
        return sharedPreferences.getString("team",this.teamName);
    }


    public boolean isFavoriteTeamSelected()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favorite team",context.MODE_PRIVATE);
        boolean isFavTeamEmpty = sharedPreferences.getString("team","").isEmpty();
        return isFavTeamEmpty;
    }
}
