package de.sample.naci.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.sample.naci.composetutorial.examples.AnimateSomethingAsState
import de.sample.naci.composetutorial.examples.CircularLoading
import de.sample.naci.composetutorial.examples.ColumnsAndRows
import de.sample.naci.composetutorial.examples.CompositionLocals
import de.sample.naci.composetutorial.examples.FullFledgedScaffold
import de.sample.naci.composetutorial.examples.ImageCardTutorial
import de.sample.naci.composetutorial.examples.MaterialPlayground
import de.sample.naci.composetutorial.examples.Modifiers
import de.sample.naci.composetutorial.examples.States
import de.sample.naci.composetutorial.examples.StylingText
import de.sample.naci.composetutorial.examples.TextFieldButtonSnackbar
import de.sample.naci.composetutorial.examples.Zoomable
import de.sample.naci.composetutorial.examples.memory.TextBoxToRecompose
import de.sample.naci.composetutorial.examples.motions.AnimatedContentDemo
import de.sample.naci.composetutorial.examples.motions.AnimatedVisibilityDemo
import de.sample.naci.composetutorial.examples.motions.CrossfadeDemo
import de.sample.naci.composetutorial.examples.motions.CrossfadeDemo2
import de.sample.naci.composetutorial.examples.motions.UpdateTransitionsDemo
import de.sample.naci.composetutorial.examples.motions.draganddroplist.DragDropList
import de.sample.naci.composetutorial.examples.navigation.NavigationDemo
import de.sample.naci.composetutorial.examples.stationaries.CanvasDemo
import de.sample.naci.composetutorial.examples.stationaries.MultipleStickyHeaders
import de.sample.naci.composetutorial.examples.stationaries.Shapes
import de.sample.naci.composetutorial.examples.stationaries.StaggeredGridDemo
import de.sample.naci.composetutorial.examples.stationaries.StickyHeaderDemo
import de.sample.naci.composetutorial.examples.system.BackPressHandler
import de.sample.naci.composetutorial.extensions.swap
import de.sample.naci.composetutorial.navigation.Screen1
import de.sample.naci.composetutorial.navigation.Screen2
import javax.inject.Inject

class MainActivity : ComponentActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ComposeSampleApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContent {
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

