package com.example.administorzz.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by administorzz on 2017/4/5.
 */

public class GalleryActivity extends AppCompatActivity {
    final private int CAMERA_REQUEST =1;
    GridView gridview;
    byte[] imgName;
    Bitmap bitmap;
    int imgID;
    DBHelper2 db2;
    ArrayList<ImageList> imageArry = new ArrayList<ImageList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridview = (GridView)findViewById(R.id.GridViewcontent);
        db2 = new DBHelper2(this);
        byte[] bytes = new byte[100];
        Arrays.fill( bytes, (byte) 1 );

        List<ImageList> contacts= db2.getAllContacts();
        for (ImageList cn : contacts) {
            String log = "ID:" + cn.get_id() + " Name: " + cn.getName()
                    + " ,Image: " + cn.getImage();

            // Writing Contacts to log
            Log.d("Result: ", log);
            // add contacts data in arrayList
            imageArry.add(cn);

        }
        ViewAdapter viewAdapter = new ViewAdapter(this, R.layout.gallery_item, imageArry);
        gridview.setAdapter(viewAdapter);

        final String[] option = new String[] {"Take from Camera"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, option);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Log.e("Selected Item", String.valueOf(which));
                if (which == 0) {
                    // callCamera();
                }


            }
        });
        final AlertDialog dialog = builder.create();

        //Button addImage = (Button) findViewById(R.id.addImage);

        FloatingActionButton fabutton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fabutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callCamera();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case CAMERA_REQUEST:

                Bundle extras = data.getExtras();

                if (extras != null) {
                    Bitmap yourImage = extras.getParcelable("data");
                    // convert bitmap to byte
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();

                    // Inserting Contacts
                    Log.d("Insert: ", "Inserting ..");
                    db2.addContact(new ImageList("Photo", imageInByte));
                    Intent i = new Intent(GalleryActivity.this,
                            GalleryActivity.class);
                    startActivity(i);
                    finish();

                }
                break;
        }

    }
    public void callCamera()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 200);
    }
}
