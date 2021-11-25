package de.sample.naci.composetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import de.sample.naci.composetutorial.examples.memory.TextBoxToRecompose
import de.sample.naci.composetutorial.examples.motions.draganddroplist.DragDropList
import de.sample.naci.composetutorial.examples.navigation.NavigationDemo
import de.sample.naci.composetutorial.extensions.swap
import de.sample.naci.composetutorial.gamepager.GamePagerActivity
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ComposeSampleApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = {
                TopAppBar(
                    title = { Text(text = "Thou shall compose") },
                    actions = {
                        IconButton(onClick = ::onGamePagerActivityClicked) {
                            Icon(painter = painterResource(id = R.drawable.ic_gaming_24), contentDescription = "Search")
                        }
                    }
                )
            }) {

//            ColumnsAndRows()
//            Modifiers()
//            ImageCardTutorial()
//            StylingText()
//            States()
//            TextFieldButtonSnackbar()
//            StickyHeaderDemo()
//            MultipleStickyHeaders()
//            CircularLoading()
//            Zoomable()
//            FullFledgedScaffold()
//            MaterialPlayground()
//            CompositionLocals()
//            BackPressHandler()
//            CanvasDemo()
//            Shapes()
//            AnimateSomethingAsState()
//            CrossfadeDemo()
//            CrossfadeDemo2()
//            AnimatedVisibilityDemo()
//            AnimatedContentDemo()
//            UpdateTransitionsDemo()
//            TextBoxToRecompose(clicks = mainViewModel.clickCount, onClick = this::onTextBoxClicked)
//            DragDropList(items = mainViewModel.dragAndDropList, onMove = ::onMove)
//            StaggeredGridDemo()
            NavigationDemo(mainViewModel)

            }
        }
    }

    //For pagination example, go to Game Pager Demo
    fun onGamePagerActivityClicked(){
        startActivity(Intent(this, GamePagerActivity::class.java))
    }

    fun onTextBoxClicked() {
        mainViewModel.clickCount += 1
        setContent {
            TextBoxToRecompose(clicks = mainViewModel.clickCount, onClick = this::onTextBoxClicked)
        }
    }

    fun onMove(take: Int, with: Int) {
        mainViewModel.dragAndDropList = mainViewModel.dragAndDropList.swap(take, with)

        setContent {
            DragDropList(items = mainViewModel.dragAndDropList, onMove = ::onMove)
        }
    }
}

