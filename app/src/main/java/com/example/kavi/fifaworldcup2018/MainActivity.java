package com.example.kavi.fifaworldcup2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kavi.fifaworldcup2018.model.MyPref;
import com.example.kavi.fifaworldcup2018.model.Team;
import com.example.kavi.fifaworldcup2018.utils.TeamList;
import com.example.kavi.fifaworldcup2018.view.CustomGridAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       if (!new MyPref(this).isFavoriteTeamSelected()) {
            //here: check if favorite team is selected or not
            startHomeActivity();
        }

        ArrayList<Team> list_team = TeamList.getTeamList();


        final CustomGridAdapter adapter = new CustomGridAdapter(MainActivity.this,list_team);


        grid =(GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current Team that was clicked on
                Team currentTeam = adapter.getItem(position);
                Toast.makeText(getBaseContext(),"You selected "+currentTeam.getTeamName(),
                        Toast.LENGTH_SHORT).show();
                saveSelectedTeam(currentTeam.getTeamName());
               // Log.d("", String.valueOf(currentTeam.getTeamFlag()));
                Intent intent = new Intent(view.getContext(),HomeActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveSelectedTeam(String teamName) {
        new MyPref(this).saveFavoriteTeam(teamName);
    }



}
