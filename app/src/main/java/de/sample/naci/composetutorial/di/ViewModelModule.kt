package de.sample.naci.composetutorial.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.sample.naci.composetutorial.ComposeSampleViewModelFactory
import de.sample.naci.composetutorial.MainViewModel
import de.sample.naci.composetutorial.gamepager.GamePagerViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ComposeSampleViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(GamePagerViewModel::class)
    abstract fun bindGamePagerViewModel(gamePagerViewModel: GamePagerViewModel): ViewModel
}