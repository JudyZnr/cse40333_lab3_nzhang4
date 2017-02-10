package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by administorzz on 17/2/10.
 */

public class ScheduleAdpater extends ArrayAdapter<Team>{
    private int resourceId;
    public ScheduleAdpater(Context context, int textViewResourceId, ArrayList<Team> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        Team team= getItem(position);
        View view =LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView teamLogo= (ImageView) view.findViewById(R.id.teamLogo);
        TextView teamName = (TextView) view.findViewById(R.id.teamName);
        TextView teamDate = (TextView) view.findViewById(R.id.teamDate);

        teamLogo.setImageResource(team.getImageId());
        teamName.setText(team.getTeamName());
        teamDate.setText(team.getTeamDate());
        return view;

    }


}
