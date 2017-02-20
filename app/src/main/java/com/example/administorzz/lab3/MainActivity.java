package com.example.administorzz.lab3;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Team> scheduleList = new ArrayList<Team>();
        Team chicago_state = new Team("chicago_state", R.drawable.chicago_state, "Feb 2", "Emil and Patricia Jones Convocation Center", "Cougars", 70);
        Team georgia_tech = new Team("georgia_tech", R.drawable.georgia_tech, "Feb 7", "Bobby Dodd Stadium", "Yellow Jackets", 33);
        Team north_carolina = new Team("north_carolina", R.drawable.north_carolina, "Mar 2", "Kenan Memorial Stadium", "Tar Heels", 43);
        Team north_virginia = new Team("north_virginia", R.drawable.north_virginia, "Mar 13", "Charlottesville Scott Stadium", "Hokies", 16);
        Team wake_forest = new Team("wake_forest", R.drawable.wake_forest, "Mar 30", "BB&T Field", "Deakons", 59);
        Team florida_state = new Team("florida_state", R.drawable.florida_state, "Apr 1", "Doak Campbell Stadium", "Seminoles", 8);
        Team ohio_state = new Team("ohio_state", R.drawable.ohio_state, "Apr 20", "Ohio Stadium", "Buckeyes", 6);
        Team boston_college = new Team("boston_college", R.drawable.boston_college, "May 5", "Boston College Alumni Stadium", "Eagles", 66);

        scheduleList.add(chicago_state);
        scheduleList.add(georgia_tech);
        scheduleList.add(north_carolina);
        scheduleList.add(north_virginia);
        scheduleList.add(wake_forest);
        scheduleList.add(florida_state);
        scheduleList.add(ohio_state);
        scheduleList.add(boston_college);

        ScheduleAdpater adpater = new ScheduleAdpater(MainActivity.this, R.layout.schedule_item, scheduleList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Team team= scheduleList.get(position);
                String name =team.getTeamName();
                String nick = team.getNickName();
                String rank2=String.valueOf(team.getRank());

                String time = team.getTeamDate();
                String site = team.getMatchSite();




                Intent intent = new Intent (getApplicationContext(),DetailActivity.class);
                intent.putExtra("String_data","Notre Dame");
                intent.putExtra("String_data_2","88");
                intent.putExtra("String_data_1","FightingIrish");
                intent.putExtra("String_data_3","74-83");
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

