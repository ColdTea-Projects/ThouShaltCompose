package de.sample.naci.composetutorial.examples.motions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.sample.naci.composetutorial.R
import de.sample.naci.composetutorial.examples.ImageCard

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityDemo() {
//    var visible by remember { mutableStateOf(true) }
    // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
    val visible = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    val density = LocalDensity.current

    Column() {
        Row(modifier = Modifier.height(100.dp)) {
            AnimatedVisibility(
                visibleState = visible,
                enter = slideInVertically(
                    // Slide in from 40 dp from the top.
                    initialOffsetY = { with(density) { -40.dp.roundToPx() } }
                ) + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Red)
                ) {
                    Image(painter = painterResource(id = R.drawable.kitten), contentDescription = "Kittens")
                }
            }
        }
        Row(modifier = Modifier.height(100.dp)) {
            AnimatedVisibility(
                visibleState = visible,
                enter = expandIn(expandFrom = Alignment.BottomEnd),
                exit = fadeOut(
                    // Fade in with the initial alpha of 0.3f.
                    targetAlpha = 0.3f
                )
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Green)
                ) {
                    Image(painter = painterResource(id = R.drawable.kitten), contentDescription = "Kittens")
                }
            }


        }
        Row(modifier = Modifier.height(100.dp)) {
            AnimatedVisibility(
                visibleState = visible,
                enter = expandIn(expandFrom = Alignment.BottomEnd),
                exit = shrinkOut(shrinkTowards = Alignment.BottomEnd)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Green)
                ) {
                    Box(modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .animateEnterExit(
                            enter = fadeIn(),
                            exit = fadeOut()
                        )) {
                        Image(painter = painterResource(id = R.drawable.kitten), contentDescription = "Kittens")

                    }
                }
            }


        }
        Row {
            Button(onClick = { visible.targetState = visible.currentState.not() }) {
                Text(text = "Change visibility")
            }
        }

    }

}