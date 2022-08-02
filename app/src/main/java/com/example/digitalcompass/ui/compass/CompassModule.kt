package com.example.digitalcompass.ui.compass

import com.example.digitalcompass.di.scopes.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CompassModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun compassFragment(): CompassFragment
}