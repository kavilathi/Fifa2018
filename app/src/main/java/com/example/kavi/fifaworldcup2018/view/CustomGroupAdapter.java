package com.example.kavi.fifaworldcup2018.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kavi.fifaworldcup2018.R;
import com.example.kavi.fifaworldcup2018.model.Team;
import com.example.kavi.fifaworldcup2018.model.Group;
import com.example.kavi.fifaworldcup2018.utils.TeamList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kavi on 4/1/2018.
 */

public class CustomGroupAdapter extends ArrayAdapter<Group> {


    public CustomGroupAdapter(Activity context, ArrayList<Group> groupTeam)
    {
        super(context,0,groupTeam);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listView = convertView;
        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.group_listview_single, parent, false);
        }

        Group currentGroup = getItem(position);


        ImageView group_team1_imageView = listView.findViewById(R.id.group_team1_image);
        ImageView group_team2_imageView = listView.findViewById(R.id.group_team2_image);
        ImageView group_team3_imageView = listView.findViewById(R.id.group_team3_image);
        ImageView group_team4_imageView = listView.findViewById(R.id.group_team4_image);

        TextView group_team1_text = listView.findViewById(R.id.group_team1_text);
        TextView group_team2_text = listView.findViewById(R.id.group_team2_text);
        TextView group_team3_text = listView.findViewById(R.id.group_team3_text);
        TextView group_team4_text = listView.findViewById(R.id.group_team4_text);

        TextView group_title_text = listView.findViewById(R.id.group_title_text);

        group_team1_imageView.setImageResource(currentGroup.getTeam1());
        group_team2_imageView.setImageResource(currentGroup.getTeam2());
        group_team3_imageView.setImageResource(currentGroup.getTeam3());
        group_team4_imageView.setImageResource(currentGroup.getTeam4());


        group_team1_text.setText(currentGroup.getTeamName1());
        group_team2_text.setText(currentGroup.getTeamName2());
        group_team3_text.setText(currentGroup.getTeamName3());
        group_team4_text.setText(currentGroup.getTeamName4());

        group_title_text.setText("Group "+currentGroup.getTitle());


        return listView;
    }
}
