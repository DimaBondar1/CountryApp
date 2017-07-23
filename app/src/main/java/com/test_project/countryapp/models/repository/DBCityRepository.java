package com.test_project.countryapp.models.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.test_project.countryapp.models.City;
import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.models.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class DBCityRepository implements CityRepository {

    @NonNull
    private SQLiteDatabase sqLiteDatabase;

    @NonNull
    private CountryRepository countryRepository;

    public DBCityRepository(@NonNull SQLiteDatabase sqLiteDatabase, @NonNull CountryRepository countryRepository) {
        this.sqLiteDatabase = sqLiteDatabase;
        this.countryRepository = countryRepository;

    }

    @Override
    public void removeAll() {
        sqLiteDatabase.delete(DBHelper.CITY_TABLE,
                null,
                null);
    }

    @Override
    public void add(@NonNull City city) {
        int id = (int) sqLiteDatabase.insert(DBHelper.CITY_TABLE,
                null,
                getCountryContentValues(city));

        city.setId(id);
    }

    @Override
    public void add(@NonNull String s, @NonNull Country co) {
        City ci = new City();
        ci.setCountry(co);
        ci.setName(s);
        int id1 = (int) sqLiteDatabase.insert(DBHelper.CITY_TABLE,
                null,
                getCountryContentValues(ci));

    }

    @Override
    public void addAll(@NonNull String[] strings, int id){
        for (String string:strings) {
            Country c = new Country();
            c.setId(id);
            City city = new City();
            city.setName(string);
            city.setCountry(c);

            add(city);
        }
    }

    @Override
    public void remove(@NonNull City city) {
        String whereClause = DBHelper.CITY_ID+" =?";
        String[] whereArgs = new String[]{city.getId()+""};
        sqLiteDatabase.delete(DBHelper.CITY_TABLE,
                whereClause,
                whereArgs);
    }

    @Override
    public City get(@NonNull City city) {
        Cursor cursor;
        City city1 = null;

        String [] columns = new String[]{DBHelper.CITY_ID,
                DBHelper.CITY_NAME, DBHelper.CITY_COUNTRY_ID};
        String selection = DBHelper.CITY_ID+"=?";
        String [] selectionArgs = new String[]{city.getId()+""};
        cursor = sqLiteDatabase.query(DBHelper.CITY_TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            city1 = getCity(cursor);
        }

        cursor.close();

        return city1;
    }

    @Override
    @NonNull
    public List<City> getAll() {
        Cursor cursor;
        List <City> cities = new ArrayList<City>();

        String [] columns = new String[]{DBHelper.CITY_ID,
                DBHelper.CITY_NAME, DBHelper.CITY_COUNTRY_ID};
        cursor = sqLiteDatabase.query(DBHelper.CITY_TABLE,
                columns,
                null,
                null,
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            do{
                cities.add(getCity(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();

        return cities;
    }

    @NonNull
    private ContentValues getCountryContentValues(@NonNull City model) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.CITY_NAME, model.getName());
        contentValues.put(DBHelper.CITY_COUNTRY_ID, model.getCountry().getId());

        return contentValues;
    }

    @NonNull
    private City getCity(@NonNull Cursor cursor){
        City city = new City();

        Country country = new Country();
        country.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.CITY_COUNTRY_ID)));

        city.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.CITY_ID)));
        city.setName(cursor.getString(cursor.getColumnIndex(DBHelper.CITY_NAME)));
        city.setCountry(countryRepository.get(country));

        return city;
    }
}
