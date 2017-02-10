package com.example.administorzz.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Team> scheduleList = new ArrayList<Team>();
        Team chicago_state = new Team("chicago_state", R.drawable.chicago_state, "Feb 2");
        Team georgia_tech = new Team("georgia_tech", R.drawable.georgia_tech, "Feb 7");
        Team north_carolina = new Team("north_carolina", R.drawable.north_carolina, "Mar 2");
        Team north_virginia = new Team("north_virginia", R.drawable.north_virginia, "Mar 13");
        Team wake_forest = new Team("wake_forest", R.drawable.wake_forest, "Mar 30");
        Team florida_state = new Team("florida_state", R.drawable.florida_state, "Apr 1");
        Team ohio_state = new Team("ohio_state", R.drawable.ohio_state, "Apr 20");
        Team boston_college = new Team("boston_college", R.drawable.boston_college, "May 5");

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

    }
}
