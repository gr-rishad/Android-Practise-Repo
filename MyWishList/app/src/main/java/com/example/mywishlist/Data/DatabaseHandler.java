package com.example.mywishlist.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mywishlist.Model.MyWish;

import java.util.ArrayList;
import java.util.Date;


public class DatabaseHandler extends SQLiteOpenHelper {

    private final ArrayList<MyWish> wishList=new ArrayList<>();


    public DatabaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        String CREATE_WISHES_TABLE="CREATE TABLE"+Constants.TABLE_NAME+
                "("+Constants.KEY_ID+"INTEGER PRIMARY KEY,"+Constants.TITLE_NAME+
                "TEXT,"+Constants.CONTENT_NAME+"TEXT,"+Constants.DATE_NAME+
                "LONG);";

//        String CR_TAB="CREATE TABLE"+Constants.TABLE_NAME+"("+Constants.KEY_ID+"INTEGER PRIMARY KEY,"+Constants.TITLE_NAME+
//                "TEXT,"+Constants.CONTENT_NAME+"TEXT,"+Constants.DATE_NAME+"LONG);";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);

        //create a new one
        onCreate(db);

    }
    // add content to table
    public void addWishes(MyWish myWish){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constants.TITLE_NAME,myWish.getTitle());
        values.put(Constants.CONTENT_NAME,myWish.getContent());
        values.put(Constants.DATE_NAME,java.lang.System.currentTimeMillis());

        db.insert(Constants.TABLE_NAME,null,values);
        Log.v("Wish Successfully!","Yeah");
        db.close();
    }

    //get all wishes

    public ArrayList<MyWish> getWishes(){

        String selectQuery="SELECT * FROM"+Constants.TABLE_NAME;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.query(Constants.TABLE_NAME,new String[]{Constants.KEY_ID,
                Constants.TITLE_NAME,Constants.CONTENT_NAME,Constants.DATE_NAME,
        },null,null,null,null,Constants.DATE_NAME+"DESC");

        if (cursor.moveToFirst()){
            do {

                MyWish wish= new MyWish();
                wish.setTitle(cursor.getString(cursor.getColumnIndex(Constants.TITLE_NAME)));
                wish.setTitle(cursor.getString(cursor.getColumnIndex(Constants.CONTENT_NAME)));

                java.text.DateFormat dateFormat= java.text.DateFormat.getDateInstance();
                String dataData=dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))).getTime());
                wish.setRecoedDate(dataData);

                wishList.add(wish);

            }while (cursor.moveToNext());
        }

        return wishList;
    }








}
