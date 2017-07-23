package com.test_project.countryapp.routers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.test_project.countryapp.views.cityInfo.CityInfoActivity;

public class MainRouter extends BaseNavigationRouter {

    public static final String CITY = "city";

    public MainRouter(@NonNull AppCompatActivity activity) {
        super(activity);
    }

    public void showCityInfo(@NonNull String city){
        Intent intent = new Intent(activity, CityInfoActivity.class);
        intent.putExtra(CITY, city);

        activity.startActivity(intent);
    }
}
