package com.test_project.countryapp.util.components;

import android.support.annotation.NonNull;

import com.test_project.countryapp.util.moduls.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    @NonNull
    DataComponent provideDataComponent();
}
