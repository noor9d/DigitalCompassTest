package com.example.digitalcompass.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.digitalcompass.di.compass.CompassViewModelFactory
import com.example.digitalcompass.di.scopes.AppScoped
import com.example.digitalcompass.ui.compass.CompassViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(CompassViewModel::class)
    abstract fun bindCompassViewModel(compassViewModel: CompassViewModel): ViewModel

    @Binds
    @AppScoped
    abstract fun bindViewModelFactory(factory: CompassViewModelFactory): ViewModelProvider.Factory
}