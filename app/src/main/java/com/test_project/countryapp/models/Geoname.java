package com.test_project.countryapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geoname {
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("elevation")
    @Expose
    private int elevation;
    @SerializedName("geoNameId")
    @Expose
    private int geoNameId;
    @SerializedName("feature")
    @Expose
    private String feature;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("thumbnailImg")
    @Expose
    private String thumbnailImg;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("wikipediaUrl")
    @Expose
    private String wikipediaUrl;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(int geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

}