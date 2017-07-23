package com.test_project.countryapp.models.repository;

import android.support.annotation.NonNull;

import com.test_project.countryapp.models.Country;

import java.io.ByteArrayInputStream;

public interface CountryRepository extends BaseRepository<Country>{

    void setCities(@NonNull Country country);

    void removeAll();
}
