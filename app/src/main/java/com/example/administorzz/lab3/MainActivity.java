package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ArrayList<Team> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String[]> schedulelist = new ArrayList<>();
        MyCsvFileReader csvFileReader = new MyCsvFileReader(getApplicationContext());
        schedulelist= csvFileReader.readCsvFile(R.raw.schedule);


        for(int i=0; i<schedulelist.size();i++){
            String[] str = schedulelist.get(i);
            Team team = new Team(getApplicationContext(), str[0], str[1], str[2],str[3],str[4],Integer.parseInt(str[5]),str[6]);
            teams.add(team);
        }




        ScheduleAdpater adpater = new ScheduleAdpater(MainActivity.this,R.layout.schedule_item, teams);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Team team= teams.get(position);
                String name =team.getTeamName();
                String nick = team.getNickName();
                String rank2=String.valueOf(team.getRank());

                String time = team.getTeamDate();
                String site = team.getMatchSite();
                String score=team.getScore();

                Intent intent = new Intent (getApplicationContext(),DetailActivity.class);
                intent.putExtra("String_data","Notre Dame");
                intent.putExtra("String_data_2","88");
                intent.putExtra("String_data_1","FightingIrish");
                intent.putExtra("String_data_3",score);
                intent.putExtra("String_data_4","Final");
                intent.putExtra("String_data_5",name);
                intent.putExtra("String_data_6",nick);
                intent.putExtra("String_data_7",rank2);
                intent.putExtra("String_data_8",time);
                intent.putExtra("String_data_9",site);
                intent.putExtra("int_data",team.getImageId());

                startActivity(intent);
            }
        });

    }
}

