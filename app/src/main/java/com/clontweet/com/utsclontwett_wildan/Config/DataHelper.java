package com.clontweet.com.utsclontwett_wildan.Config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Twitter.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(username text primary key, email text null, password text null, img_profil text null);";
        Log.d("Data", "onCreate : " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public boolean cekLogin(String nama, String pwd){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{nama,pwd});

        if(cursor.getCount()>0) return true;
        else return false;
    }

    public  boolean   updateuser(String email,String Img,String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("img_profil",Img);
        db.update("user", contentValues, "username = ?",new String[] { username });

        return true;
    }

    public Cursor lihatUser(String Uname){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?" , new String[]{Uname});
        cursor.moveToFirst();
        db.close();
        return cursor;
    }
}
