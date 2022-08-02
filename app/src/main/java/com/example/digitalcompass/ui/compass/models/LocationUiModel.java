package com.example.digitalcompass.ui.compass.models;

import com.example.digitalcompass.data.models.GeoPosition;

public class LocationUiModel {
    private final GeoPosition mLocation;

    public GeoPosition getLocation() {
        return mLocation;
    }

    public LocationUiModel(GeoPosition mLocation) {
        this.mLocation = mLocation;
    }
}
