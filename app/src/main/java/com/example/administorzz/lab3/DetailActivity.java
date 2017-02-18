package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by administorzz on 17/2/18.
 */

public class DetailActivity extends Activity {
    @Override

    public void onCreate (Bundle bundle) {

        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);

//initialize all the widgets of your layout file here.
        TextView date = (TextView) findViewById(R.id.dateTime);
        TextView site = (TextView) findViewById(R.id.matchSite);
        TextView teamName1 = (TextView) findViewById(R.id.teamName1);
        TextView teamName2 = (TextView) findViewById(R.id.teamName2);
        TextView nickName1 = (TextView) findViewById(R.id.nickName1);
        TextView nickName2 = (TextView) findViewById(R.id.nickName2);
        TextView rank1 = (TextView) findViewById(R.id.rank1);
        TextView rank2 = (TextView) findViewById(R.id.rank2);
        TextView score = (TextView) findViewById(R.id.Score);
        TextView section = (TextView) findViewById(R.id.section);
        ImageView teamLogo1 = (ImageView) findViewById(R.id.imageView);
        ImageView teamLogo2 = (ImageView) findViewById(R.id.imageView1);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);

        Intent intent = getIntent();
        bundle = intent.getBundleExtra("team");
        teamName1.setText(bundle.getString("teamName1"));
        teamName2.setText(bundle.getString("teamName2"));
        date.setText(bundle.getString("teamTime"));
        site.setText(bundle.getString("teamSite"));
        nickName1.setText(bundle.getString("nickName1"));
        nickName2.setText(bundle.getString("nickName2"));
        rank1.setText(bundle.getInt("teamRank1"));
        rank2.setText(bundle.getInt("teamRank2"));
        score.setText(bundle.getString("teamScore"));
        section.setText(bundle.getString("teamScore"));

        teamLogo1.setImageResource(bundle.getInt("teamImage1"));
        teamLogo2.setImageResource(R.drawable.fightingirish);





    }
}
