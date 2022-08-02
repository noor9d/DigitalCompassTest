package com.example.digitalcompass.ui.updatedestination

import com.example.digitalcompass.di.scopes.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UpdateDestinationModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun updateDestinationFragment(): UpdateDestinationFragment
}