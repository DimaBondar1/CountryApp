package com.test_project.countryapp.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.version;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    public static final String DB_NAME = "test";
    public static final String COUNTRY_TABLE = "country";
    public static final String COUNTRY_ID = "country_id";
    public static final String COUNTRY_NAME = "country_name";
    public static final String COUNTRY_CITIES = "country_cities";
    public static final String CITY_TABLE = "city";
    public static final String CITY_ID = "city_id";
    public static final String CITY_NAME = "city_name";
    public static final String CITY_COUNTRY_ID = "city_country";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("11","12313");
        db.execSQL("CREATE TABLE "+COUNTRY_TABLE+" ("
                + COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COUNTRY_NAME + " TEXT NOT NULL, "
                + COUNTRY_CITIES + " TEXT );");

//        db.execSQL("CREATE TABLE "+CITY_TABLE+" ("
//                +CITY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
//                +CITY_NAME+ " TEXT NOT NULL,"
//                +CITY_COUNTRY_ID+" INTEGER,"
//                +" FOREIGN KEY ("+CITY_COUNTRY_ID+") REFERENCES "+COUNTRY_TABLE+"("+COUNTRY_ID+"));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
