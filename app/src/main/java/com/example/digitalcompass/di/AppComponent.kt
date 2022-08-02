package com.example.digitalcompass.di

import android.app.Application
import com.example.digitalcompass.App
import com.example.digitalcompass.data.source.CompassRepositoryModule
import com.example.digitalcompass.di.scopes.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    CompassRepositoryModule::class,
    ViewModelsModule::class,
    AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App> {


    // we can now do DaggerAppComponent.builder().application(this).build().inject(this),
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}