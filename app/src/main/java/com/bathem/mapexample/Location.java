package com.bathem.mapexample;

/**
 * Created by mehtab on 15/08/2016.
 */
public class Location {
    private String locationName;
    private double latitude;
    private double longitude;

    Location(String locatioName, double latitude, double longitude) {
        this.locationName = locatioName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
