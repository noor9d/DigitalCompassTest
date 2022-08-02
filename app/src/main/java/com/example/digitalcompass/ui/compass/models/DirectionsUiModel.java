package com.example.digitalcompass.ui.compass.models;

import com.example.digitalcompass.data.models.CompassOrientation;

public class DirectionsUiModel {
    private final CompassOrientation mCompassOrientation;

    public CompassOrientation getCompassOrientation() {
        return mCompassOrientation;
    }


    public DirectionsUiModel(CompassOrientation compassOrientation) {
        this.mCompassOrientation = compassOrientation;
    }
}
