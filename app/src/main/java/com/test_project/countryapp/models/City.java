package com.test_project.countryapp.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class City {

    @Nullable
    private Integer id;

    @Nullable
    private String name;

    @Nullable
    private Country country;

    public City() {
    }

    public City(@NonNull Integer id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public City(@NonNull Integer id, @NonNull String name, @NonNull Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
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
    public Country getCountry() {
        return country;
    }

    public void setCountry(@NonNull Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country.getId() +
                '}';
    }
}
