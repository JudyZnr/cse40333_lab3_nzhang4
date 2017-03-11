package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by administorzz on 17/2/18.
 */

public class DetailActivity extends Activity {

    private Button button;
    private static final int CAMERA_REQUEST=1888;


    @Override

    protected void onCreate(Bundle bundle) {

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
        teamLogo1.setImageResource(getIntent().getIntExtra("int_data", 0));

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //File PictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                //String pictureName = getPictureName();
                //File imageFile = new File(PictureDirectory, pictureName);
                //Uri pictureUri = Uri.fromFile(imageFile);
                //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                //cameraIntent.putExtra("data", pictureUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }



        });


    }
    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "BestMoments" + timestamp + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                //Intent photoGalleryIntent = new Intent(Intent.ACTION_PICK);
                //File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                //String pictureDirectoryPath = pictureDirectory.getPath();
                //Uri imageUri = Uri.parse(pictureDirectoryPath);
                Bundle extras = data.getExtras();

               // InputStream inputStream;
                //try {
                   // inputStream = getContentResolver().openInputStream(imageUri);

                   // Bitmap image = BitmapFactory.decodeStream(inputStream);
                    Bitmap image = (Bitmap) extras.get("data");
                    ImageView imgView = (ImageView) findViewById(R.id.cameraPicture);
                    imgView.setImageBitmap(image);

               // } catch (FileNotFoundException e) {
               //     e.printStackTrace();
               // }
            }
        }
        ;

    }
}