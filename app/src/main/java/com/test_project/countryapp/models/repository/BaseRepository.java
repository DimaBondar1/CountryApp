package com.test_project.countryapp.models.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test_project.countryapp.util.components.AppComponent;
import com.test_project.countryapp.util.components.DaggerAppComponent;

import java.util.List;

public interface BaseRepository<K> {

    void add(@NonNull K k);

    void remove(@NonNull K k);

    K get(@NonNull K k);

    @NonNull
    List<K> getAll();
}
