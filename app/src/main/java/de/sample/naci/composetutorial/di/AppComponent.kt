package de.sample.naci.composetutorial.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import de.sample.naci.composetutorial.MainActivity
import de.sample.naci.composetutorial.gamepager.GamePagerActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(gamePagerActivity: GamePagerActivity)

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

}