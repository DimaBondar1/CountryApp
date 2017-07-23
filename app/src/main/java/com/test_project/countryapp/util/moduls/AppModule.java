package com.test_project.countryapp.util.moduls;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @NonNull
    private Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @NonNull
    @Provides
    @Singleton
    public Application getApp(){
        return application;
    }
}
