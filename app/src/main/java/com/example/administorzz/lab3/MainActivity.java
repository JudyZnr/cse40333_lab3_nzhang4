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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Team> teams = new ArrayList<>();
        final ArrayList<Team> schedulelist = new ArrayList<Team>();
        MyCsvFileReader csvFileReader = new MyCsvFileReader(getApplicationContext());
        teams = csvFileReader.readCsvFile(R.raw.schedule);

        for(int i=0; i<teams.size();i++){
            schedulelist.add(teams.get(i));
        }




        ScheduleAdpater adpater = new ScheduleAdpater(MainActivity.this,R.layout.schedule_item, schedulelist);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Team team= schedulelist.get(position);
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

