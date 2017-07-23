package com.test_project.countryapp.models.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.models.DBHelper;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DBCountryRepository implements CountryRepository{

    @NonNull
    private SQLiteDatabase sqLiteDatabase;

    public DBCountryRepository(@NonNull SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void setCities(@NonNull Country country) {
        Cursor cursor;
        Gson gson = new GsonBuilder().create();

        String [] columns = new String[]{DBHelper.COUNTRY_CITIES};
        String selection = DBHelper.COUNTRY_ID+"=?";
        String [] selectionArgs = new String[]{country.getId()+""};

        cursor = sqLiteDatabase.query(DBHelper.COUNTRY_TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            country.setCityList(
                    gson.fromJson(cursor.getString(cursor.getColumnIndex(DBHelper.COUNTRY_CITIES)),
                            String[].class));

        }

        cursor.close();
    }

    @Override
    public void removeAll() {
        sqLiteDatabase.delete(DBHelper.COUNTRY_TABLE,
                null,
                null);
    }

    @Override
    public void add(@NonNull Country country) {

        int id = (int) sqLiteDatabase.insert(DBHelper.COUNTRY_TABLE,
                null,
                getCountryContentValues(country));

        country.setId(id);
    }

    @Override
    public void remove(@NonNull Country country) {
        String whereClause = DBHelper.COUNTRY_ID+" =?";
        String[] whereArgs = new String[]{country.getId()+""};
        sqLiteDatabase.delete(DBHelper.COUNTRY_TABLE,
                whereClause,
                whereArgs);
    }

    @Override
    public Country get(@NonNull Country country) {
        Cursor cursor;
        Country country1 = null;
        String [] columns = new String[]{DBHelper.COUNTRY_ID,
                DBHelper.COUNTRY_NAME};
        String selection = DBHelper.COUNTRY_ID+"=?";
        String [] selectionArgs = new String[]{country.getId()+""};
        cursor = sqLiteDatabase.query(DBHelper.COUNTRY_TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            country1 = getCountry(cursor);
        }

        cursor.close();

        return country1;
    }

    @Override
    @NonNull
    public List<Country> getAll() {
        Cursor cursor;
        List <Country> countries = new ArrayList<Country>();

        String [] columns = new String[]{DBHelper.COUNTRY_ID,
                DBHelper.COUNTRY_NAME};
        cursor = sqLiteDatabase.query(DBHelper.COUNTRY_TABLE,
                columns,
                null,
                null,
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            do{
                countries.add(getCountry(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();

        return countries;
    }

    @NonNull
    private ContentValues getCountryContentValues(@NonNull Country model) {
        ContentValues contentValues = new ContentValues();
        String jsonArray = null;

        try {
            jsonArray = new JSONArray(model.getCityList()).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        contentValues.put(DBHelper.COUNTRY_NAME, model.getName());
        contentValues.put(DBHelper.COUNTRY_CITIES, jsonArray);
        return contentValues;
    }

    @NonNull
    private Country getCountry(@NonNull Cursor cursor){
        Country country = new Country();

        country.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COUNTRY_ID)));
        country.setName(cursor.getString(cursor.getColumnIndex(DBHelper.COUNTRY_NAME)));

        return country;
    }
}
