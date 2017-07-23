package com.test_project.countryapp.routers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test_project.countryapp.R;

public abstract class BaseNavigationRouter {

    @NonNull
    protected AppCompatActivity activity;

    public BaseNavigationRouter(@NonNull AppCompatActivity activity) {
        this.activity = activity;
    }

    protected void showActivity(@NonNull Class<? extends Activity> activityClass){
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }
}
