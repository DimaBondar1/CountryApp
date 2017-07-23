package com.test_project.countryapp.routers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.test_project.countryapp.views.main.MainActivity;

public class SplashScreenRouter extends BaseNavigationRouter {

    public SplashScreenRouter(@NonNull AppCompatActivity activity) {
        super(activity);
    }

    public void showMainActivity(){
        showActivity(MainActivity.class);
    }
}
