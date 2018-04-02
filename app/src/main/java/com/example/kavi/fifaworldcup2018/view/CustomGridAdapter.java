package com.example.kavi.fifaworldcup2018.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavi.fifaworldcup2018.R;
import com.example.kavi.fifaworldcup2018.model.Team;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kavi on 3/17/2018.
 */

public class CustomGridAdapter extends ArrayAdapter<Team> {



   public CustomGridAdapter(Activity context, ArrayList<Team> list_team)
   {
       super(context, 0, list_team);
   }




    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View grid = convertView;
        if (convertView == null){
            grid = LayoutInflater.from(getContext()).inflate(R.layout.grid_single,parent,false);
        }
        Team team = getItem(position);
        TextView textView =  grid.findViewById(R.id.grid_text);
        textView.setText(team.getTeamName());
        CircleImageView imageView =  grid.findViewById(R.id.grid_image);
        imageView.setImageResource(team.getTeamFlag());

        return grid;
    }
}
