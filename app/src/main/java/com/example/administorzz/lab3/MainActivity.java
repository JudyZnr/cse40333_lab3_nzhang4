package com.example.administorzz.lab3;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<String[]> schedulelist = new ArrayList<>();
    private CoordinatorLayout coordinatorlayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        toolbar.setTitle("ND Atheletics");

        Button btn = (Button) findViewById(R.id.button_example);
        registerForContextMenu(btn);


        MyCsvFileReader csvFileReader = new MyCsvFileReader(getApplicationContext());
        schedulelist= csvFileReader.readCsvFile(R.raw.schedule);


        for(int i=0; i<schedulelist.size();i++){
            String[] str = schedulelist.get(i);
            Team team1 = new Team(getApplicationContext(), str[0], str[1], str[2],str[3],str[4],Integer.parseInt(str[5]),str[6]);
            teams.add(team1);
        }
        System.out.println(schedulelist);



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
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
// code for sharing the schedule
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            //shareIntent.putExtra(Intent.EXTRA_TEXT, "BasketBall Matches");
            shareIntent.putExtra(Intent.EXTRA_TEXT, gameSchedule());
            startActivity(shareIntent);
        }

        else if (res_id == R.id.sync) {
// Snackbar with Try Again action
            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);

            snackbar.setAction("Try Again", new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();

                }

            });

            snackbar.show();

        }


        else if (res_id == R.id.settings) {
// Floating Contextual Menu with options

        }
        return true;
    }
    public String gameSchedule() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0; j<7;j++){
            stringBuilder.append(schedulelist.get(j)[1]);
        }
        //stringBuilder.append(schedulelist.get(1)[1]);
        return stringBuilder.toString();
    }
    //public String gameSchedule(){
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.floating_contextual_menu,menu);
    }

    //}
}

