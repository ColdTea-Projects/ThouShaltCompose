package de.sample.naci.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import de.sample.naci.composetutorial.examples.stationaries.CanvasDemo
import de.sample.naci.composetutorial.examples.stationaries.MultipleStickyHeaders
import de.sample.naci.composetutorial.examples.stationaries.Shapes
import de.sample.naci.composetutorial.examples.stationaries.StickyHeaderDemo
import de.sample.naci.composetutorial.examples.system.BackPressHandler

class MainActivity : ComponentActivity() {
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
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
            TextBoxToRecompose(clicks = mainViewModel.clickCount, onClick = this::onTextBoxClicked)
        }
    }

    fun onTextBoxClicked() {
        mainViewModel.clickCount += 1
        setContent {
            TextBoxToRecompose(clicks = mainViewModel.clickCount, onClick = this::onTextBoxClicked)
        }
    }
}

