package com.example.digitalcompass.data.source.location;

import com.example.digitalcompass.data.models.GeoPosition;
import io.reactivex.Flowable;

public interface LocationDataSource {
    Flowable<GeoPosition> getLocationUpdates();
}
