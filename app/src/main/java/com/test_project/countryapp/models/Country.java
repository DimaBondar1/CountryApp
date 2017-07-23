package com.test_project.countryapp.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public class Country {

    @Nullable
    private Integer id;

    @Nullable
    private String name;

    @Nullable
    private String[] cityList;

    public Country() {
    }

    public Country(@NonNull Integer id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public Country(@NonNull Integer id, @NonNull String name, @NonNull String[] cityList) {
        this.id = id;
        this.name = name;
        this.cityList = cityList;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Nullable
    public String[] getCityList() {
        return cityList;
    }

    public void setCityList(@NonNull String[] cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
