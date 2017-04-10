package com.example.administorzz.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by administorzz on 2017/3/23.
 */

public class DBHelper extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public static String DATABASE_NAME = "teams.db";
    public static String TABLE_TEAM = "Team";
    public static String TABLE_IMAGE = "Images";
    public static int DATABASE_VERSION = 1;
    public static String COL_NAME = "team_name";
    public static String COL_NICKNAME = "team_nickname";
    public static String COL_SITE = "team_site";
    public static String COL_ID = "_id";
    public static String COL_IMAGE = "imageId";
    public static String COL_SCORE = "team_score";
    public static String COL_RANK = "team_rank";
    public static String COL_PATH = "image_path";

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL("CREATE TABLE" + TABLE_TEAM + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COL_NAME + " String" + COL_IMAGE + " int"
        + COL_SITE + " String " + COL_NICKNAME + " String" + COL_SCORE + " String" + COL_RANK + " int );");
    }
    @Override
    public void onUpgrade(SQLiteDatabase database , int oldVersion, int newVersion){
        database.execSQL("DROP if exists TABLE" + TABLE_TEAM);
        onCreate(database);
    }
    public void insertData (Team team) {
        database = getWritableDatabase();
        database.execSQL("INSERT INTO" + TABLE_TEAM + "(" + COL_ID + "," + COL_NAME + "," + COL_SITE + "," + COL_NICKNAME + "," + COL_SCORE + "," + COL_RANK + ")"
                                       + "VALUES (" + team.get_id() + "," + team.getTeamName() + "," + team.getImageId() + "," + team.getMatchSite() + "," + team.getNickName()
                                       + "," + team.getScore() + "," + team.getRank() + ");");
        ContentValues contentValues = new ContentValues();
        long ret = database.insert(TABLE_TEAM, null, contentValues );

        if (ret > 0) {
            System.out.println("Successfully inserted");
        } else {
            System.out.println("Unsuccessfully insert");
        }
    }
    public void deleteData(int team_id){
        database = getWritableDatabase();
        database.delete(TABLE_TEAM, "_id=", new String[]{Integer.toString(team_id)});
        database.close();

    }


}
