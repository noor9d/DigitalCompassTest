package com.example.digitalcompass.data.source

import com.example.digitalcompass.data.source.location.CompassLocationSource
import com.example.digitalcompass.data.source.location.CompassLocationSourceModule
import com.example.digitalcompass.data.source.location.LocationDataSource
import com.example.digitalcompass.data.source.orientation.CompassOrientationSource
import com.example.digitalcompass.data.source.orientation.CompassOrientationSourceModule
import com.example.digitalcompass.data.source.orientation.OrientationDataSource
import com.example.digitalcompass.di.scopes.AppScoped
import com.example.digitalcompass.sensors.ReactiveSensors
import com.patloew.rxlocation.RxLocation
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(CompassOrientationSourceModule::class, CompassLocationSourceModule::class))
class CompassRepositoryModule {
    @Provides
    @AppScoped
    internal fun provideCompassOrientationSource(reactiveSensors: ReactiveSensors): OrientationDataSource {
        return CompassOrientationSource(reactiveSensors)
    }

    @Provides
    @AppScoped
    internal fun provideCompassLocationSource(rxLocation: RxLocation): LocationDataSource {
        return CompassLocationSource(rxLocation)
    }
}