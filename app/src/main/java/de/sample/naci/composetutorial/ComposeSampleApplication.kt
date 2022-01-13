package de.sample.naci.composetutorial

import android.app.Application
import de.sample.naci.composetutorial.di.AppComponent
import de.sample.naci.composetutorial.di.DaggerAppComponent
import timber.log.Timber

open class ComposeSampleApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}