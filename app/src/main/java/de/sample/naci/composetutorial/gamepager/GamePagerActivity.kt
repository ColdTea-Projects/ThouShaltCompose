package de.sample.naci.composetutorial.gamepager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import de.sample.naci.composetutorial.ComposeSampleApplication
import de.sample.naci.composetutorial.examples.TextFieldButtonSnackbar
import de.sample.naci.composetutorial.gamepager.composables.GameListing
import de.sample.naci.composetutorial.gamepager.composables.HomeAppBar
import de.sample.naci.composetutorial.gamepager.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class GamePagerActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val gamePagerViewModel: GamePagerViewModel by viewModels { viewModelFactory }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ComposeSampleApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            setContent {
                Scaffold(
                    topBar = {
                        HomeAppBar(title = "Game Pager", openSearch = { }, openFilters = {})
                    },
                    content = {
                        GameListing(games = gamePagerViewModel.getAllGames())
                    }
                )
            }

        }
    }
}