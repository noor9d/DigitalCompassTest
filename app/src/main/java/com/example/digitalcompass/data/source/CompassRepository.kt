package com.example.digitalcompass.data.source

import com.example.digitalcompass.data.models.CompassOrientation
import com.example.digitalcompass.data.models.GeoPosition
import com.example.digitalcompass.data.source.location.LocationDataSource
import com.example.digitalcompass.data.source.orientation.OrientationDataSource
import com.example.digitalcompass.di.scopes.AppScoped

import javax.inject.Inject

import io.reactivex.Flowable
import io.reactivex.Single

@AppScoped
class CompassRepository @Inject constructor(
    private val compassOrientationSource: OrientationDataSource,
    private val compassLocationDataSource: LocationDataSource
    ) : OrientationDataSource, LocationDataSource {

    override fun getOrientation(): Flowable<CompassOrientation> {
        return compassOrientationSource.orientation
    }

    /**
     * Every time a location update occurs, the orientation source should update its records as well
     */
    override fun getLocationUpdates(): Flowable<GeoPosition> {
        return compassLocationDataSource.locationUpdates
                .flatMap { geoPosition ->
                    // Perform update
                    updateCurrentLocation(geoPosition)
                    Flowable.just(geoPosition)
                }
    }

    override fun updateCurrentLocation(position: GeoPosition) {
        compassOrientationSource.updateCurrentLocation(position)
    }

    override fun getDestinationLocation(): Single<GeoPosition> {
        return compassOrientationSource.destinationLocation
    }

    override fun updateDestinationPosition(position: GeoPosition) {
        compassOrientationSource.updateDestinationPosition(position)
    }
}
