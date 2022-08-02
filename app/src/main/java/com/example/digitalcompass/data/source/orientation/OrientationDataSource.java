package com.example.digitalcompass.data.source.orientation;

import com.example.digitalcompass.data.models.CompassOrientation;
import com.example.digitalcompass.data.models.GeoPosition;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface OrientationDataSource {
    Flowable<CompassOrientation> getOrientation();

    Single<GeoPosition> getDestinationLocation();

    void updateDestinationPosition(GeoPosition destinationPosition);

    void updateCurrentLocation(GeoPosition position);
}
