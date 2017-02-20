package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by administorzz on 17/2/18.
 */

public class DetailActivity extends Activity {

    private Button button;
    @Override

    protected void onCreate (Bundle bundle) {

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

        //Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivity(cameraIntent);
        teamName1.setText(getIntent().getStringExtra("String_data_5"));
        teamName2.setText(getIntent().getStringExtra("String_data"));
        nickName1.setText(getIntent().getStringExtra("String_data_6"));
        nickName2.setText(getIntent().getStringExtra("String_data_1"));
        rank1.setText(getIntent().getStringExtra("String_data_7"));
        rank2.setText(getIntent().getStringExtra("String_data_2"));
        teamLogo2.setImageResource(R.drawable.fightingirish);
        score.setText(getIntent().getStringExtra("String_data_3"));
        section.setText(getIntent().getStringExtra("String_data_4"));
        date.setText(getIntent().getStringExtra("String_data_8"));
        site.setText(getIntent().getStringExtra("String_data_9"));
        teamLogo1.setImageResource(getIntent().getIntExtra("int_data",0));

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });

    }

}
