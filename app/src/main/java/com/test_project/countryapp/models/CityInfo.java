package com.test_project.countryapp.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfo {

    @SerializedName("geonames")
    @Expose
    @NonNull
    private List<Geoname> geonames = new ArrayList<Geoname>();

    @NonNull
    public List<Geoname> getGeonames() {
        return geonames;
    }

    public void setGeonames(@NonNull List<Geoname> geonames) {
        this.geonames = geonames;
    }

}