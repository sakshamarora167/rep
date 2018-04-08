package com.example.orangerabbit.getfit;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{

    public static final String Database_name = "register.db";
    public static final String Table_name = "register";
    public static final String Col_1 = "Id";
    public static final String Col_2 = "FirstName";
    public static final String Col_3 = "LastName";
    public static final String Col_4 = "Passs";
    public static final String Col_5 = "Email";
    public static final String Col_6 = "PhoneNum";

    public Database(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName text,LastName TEXT,Pass TEXT,Email TEXT,PhoneNum TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+ Table_name);
        onCreate(db);
    }
}
