package com.example.administorzz.lab3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/**
 * Created by administorzz on 2017/4/7.
 */

public class ViewAdapter extends ArrayAdapter<ImageList> {
      private int layoutResourceId;
      Context context;
      ArrayList<ImageList> objects = new ArrayList<ImageList>();
    public ViewAdapter(Context context, int layoutResourceId, ArrayList<ImageList> objects) {
        super(context, layoutResourceId, objects);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.objects = objects;
    }
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ImageHolder imageHolder = null;
        if(view == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);

            imageHolder = new ImageHolder();
            imageHolder.imageName = (TextView)view.findViewById(R.id.imageName);
            imageHolder.imageCamera = (ImageView)view.findViewById(R.id.imageCamera);
            view.setTag(imageHolder);
        }
        else
        {
          imageHolder = (ImageHolder)view.getTag();
        }

        ImageList picture = objects.get(position);
        imageHolder.imageName.setText(picture.getName());

        //convert byte to bitmap take from contact class

        byte[] outImage=picture.getImage();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        imageHolder.imageCamera.setImageBitmap(theImage);
        return view;

    }

    static class ImageHolder
    {
        ImageView imageCamera;
        TextView imageName;
    }


}
