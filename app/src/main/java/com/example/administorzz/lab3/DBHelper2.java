package com.example.administorzz.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administorzz on 2017/4/7.
 */

public class DBHelper2 extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "images.db";
    public static String COL_NAME = "camera_name";
    public static String TABLE_IMAGE = "Images";
    public static String COL_ID = "_id";
    public static String COL_IMG = "image";
    public static int DATABASE_VERSION = 1;

    public DBHelper2(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_IMAGE + "("
                + COL_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT,"
                + COL_IMG + " BLOB" + ")";
        database.execSQL(CREATE_CONTACTS_TABLE);    }

    @Override
    public void onUpgrade(SQLiteDatabase database , int oldVersion, int newVersion){
        database.execSQL("DROP if exists TABLE" + TABLE_IMAGE);
        onCreate(database);
    }

    //Get Row Count

    public// Adding new contact
    void addContact(ImageList contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, contact.getName()); // Contact Name
        values.put(COL_IMG, contact.getImage()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_IMAGE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    ImageList getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_IMAGE, new String[] { COL_ID,
                        COL_NAME, COL_IMG }, COL_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ImageList contact = new ImageList(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getBlob(1));

        // return contact
        return contact;

    }

    // Getting All Contacts
    public List<ImageList> getAllContacts() {
        List<ImageList> contactList = new ArrayList<ImageList>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_IMAGE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ImageList contact = new ImageList();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setImage(cursor.getBlob(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // close inserting data from database
        db.close();
        // return contact list
        return contactList;
    }



}
