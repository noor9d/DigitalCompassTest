package com.example.digitalcompass.data.source.location

import com.example.digitalcompass.data.models.GeoPosition
import com.example.digitalcompass.di.scopes.AppScoped
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation

import javax.inject.Inject
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@AppScoped
class CompassLocationSource @Inject constructor(
    private val mRxLocationProvider: RxLocation
) : LocationDataSource {

    private// 10m is more than enough to recalibrate the direction
    val customLocationRequest: LocationRequest
        get() {
            val locationRequest = LocationRequest()
            locationRequest.interval = 5000
            locationRequest.fastestInterval = 5000
            locationRequest.smallestDisplacement = 10f
            locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

            return locationRequest
        }

    override fun getLocationUpdates(): Flowable<GeoPosition> {
        return mRxLocationProvider.location().updates(customLocationRequest)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { position -> Observable.just(GeoPosition(position.latitude, position.longitude)) }
                .toFlowable(BackpressureStrategy.LATEST)
    }
}
