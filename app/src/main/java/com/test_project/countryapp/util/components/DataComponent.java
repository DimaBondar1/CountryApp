package com.test_project.countryapp.util.components;

import android.support.annotation.NonNull;

import com.test_project.countryapp.util.moduls.DataModule;
import com.test_project.countryapp.views.cityInfo.CityInfoActivity;
import com.test_project.countryapp.views.main.MainActivity;
import com.test_project.countryapp.views.splash.SplashScreenActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {DataModule.class})
public interface DataComponent {

    void inject(@NonNull SplashScreenActivity splashScreenActivity);

    void inject(@NonNull MainActivity mainActivity);

    void inject(@NonNull CityInfoActivity cityInfoActivity);
}
