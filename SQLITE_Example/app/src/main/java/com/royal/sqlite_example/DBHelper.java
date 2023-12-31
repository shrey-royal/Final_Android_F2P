package com.royal.sqlite_example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //Table Name
    public static final String TABLE_NAME = "COUNTRIES";

    //Table_Columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";     //NAME_OF_THE_COUNTRY
    public static final String DESC = "description";    //INR

    //Database Information
    static final String DB_NAME = "COUNTRIES_EXAMPLE.DB";

    //Database Version
    static final int DB_VERSION = 1;

    //Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL, " + DESC + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
