package com.clontweet.com.utsclontwett_wildan;

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
        String sql = "create table user(username text primary key, email text null, password text null);";
        Log.d("Data", "onCreate : " + sql);
        db.execSQL(sql);
//        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('1', 'Nama anda', 'tgl lahir anda', 'jenis kelamin anda', 'alamat anda');";
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
}
