package com.test_project.countryapp.models.repository;

import android.support.annotation.NonNull;

import com.test_project.countryapp.models.City;
import com.test_project.countryapp.models.Country;

public interface CityRepository extends BaseRepository<City> {

    void removeAll();

    void add(@NonNull String s, @NonNull Country co);

    void addAll(@NonNull String[] strings, int id);
}
