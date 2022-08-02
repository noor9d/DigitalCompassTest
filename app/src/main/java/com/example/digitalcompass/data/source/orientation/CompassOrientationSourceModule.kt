package com.example.digitalcompass.data.source.orientation

import android.app.Application
import com.example.digitalcompass.di.scopes.AppScoped

import com.example.digitalcompass.sensors.ReactiveSensors

import dagger.Module
import dagger.Provides

@Module
class CompassOrientationSourceModule {
    @AppScoped
    @Provides
    internal fun provideReactiveSensors(context: Application): ReactiveSensors {
        return ReactiveSensors(context)
    }
}
