package com.example.digitalcompass.ui.compass

import androidx.lifecycle.ViewModel
import com.example.digitalcompass.data.models.CompassOrientation
import com.example.digitalcompass.data.models.GeoPosition
import com.example.digitalcompass.data.source.CompassRepository
import com.example.digitalcompass.di.scopes.AppScoped
import com.example.digitalcompass.ui.compass.models.DirectionsUiModel
import com.example.digitalcompass.ui.compass.models.LocationUiModel
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

@AppScoped
class CompassViewModel @Inject constructor(private val repository: CompassRepository) : ViewModel() {


    fun getCompassUiModel(): Flowable<DirectionsUiModel> {
        return repository.orientation.map<DirectionsUiModel>{ constructCompassUiModel(it) }
    }

    fun getCurrentLocationUiModel(): Flowable<LocationUiModel> {
        return repository.locationUpdates.map<LocationUiModel>{ constructLocationUiModel(it) }
    }

    fun getDestinationLocationUiModel(): Single<LocationUiModel>{
        return repository.destinationLocation.map<LocationUiModel>{ constructLocationUiModel(it) }
    }

    fun setDestinationLocation(location: GeoPosition){
        repository.updateDestinationPosition(location)
    }

    /**
     * Internal construction methods
     */
    private fun constructCompassUiModel(compassOrientation: CompassOrientation): DirectionsUiModel {
        return DirectionsUiModel(compassOrientation)
    }

    private fun constructLocationUiModel(geoPosition: GeoPosition): LocationUiModel {
        return LocationUiModel(geoPosition)
    }
}