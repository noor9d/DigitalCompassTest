package com.example.digitalcompass.di

import com.example.digitalcompass.di.scopes.ActivityScoped
import com.example.digitalcompass.ui.compass.CompassActivity
import com.example.digitalcompass.ui.compass.CompassModule
import com.example.digitalcompass.ui.updatedestination.UpdateDestinationActivity
import com.example.digitalcompass.ui.updatedestination.UpdateDestinationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [CompassModule::class])
    internal abstract fun compassActivity(): CompassActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [UpdateDestinationModule::class])
    internal abstract fun updateDestinationActivity(): UpdateDestinationActivity
}
