package de.sample.naci.composetutorial.examples.motions

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.solver.widgets.Rectangle
import de.sample.naci.composetutorial.R
import de.sample.naci.composetutorial.ui.theme.materialBlue100

var expanded by mutableStateOf(false)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentDemo() {
    Column {
        Row {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }
            Text(text = "Count: ")
            AnimatedContent(targetState = count) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "$targetCount")
            }
        }
        Row {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }
            Button(onClick = { count-- }) {
                Text("Substract")
            }
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    // Compare the incoming number with the previous number.
                    if (targetState > initialState) {
                        // If the target number is larger, it slides up and fades in
                        // while the initial (smaller) number slides up and fades out.
                        slideInVertically({ height -> height }) + fadeIn() with
                                slideOutVertically({ height -> -height }) + fadeOut()
                    } else {
                        // If the target number is smaller, it slides down and fades in
                        // while the initial number slides down and fades out.
                        slideInVertically({ height -> -height }) + fadeIn() with
                                slideOutVertically({ height -> height }) + fadeOut()
                    }.using(
                        // Disable clipping since the faded slide-in/out should
                        // be displayed out of bounds.
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(text = "$targetCount")
            }
        }

        Row {
            AnimatedContent(
                targetState = expanded,
                transitionSpec = {
                    fadeIn(animationSpec = tween(150, 150)) with
                            fadeOut(animationSpec = tween(150)) using
                            SizeTransform { initialSize, targetSize ->
                                if (targetState) {
                                    keyframes {
                                        // Expand horizontally first.
                                        IntSize(targetSize.width, initialSize.height) at 150
                                        durationMillis = 300
                                    }
                                } else {
                                    keyframes {
                                        // Shrink vertically first.
                                        IntSize(initialSize.width, targetSize.height) at 150
                                        durationMillis = 300
                                    }
                                }
                            }
                }
            ) { targetExpanded ->
                if (targetExpanded) {
                    Expanded()
                } else {
                    ContentIcon()
                }
            }
        }
    }
}

@Composable
private fun ContentIcon() {
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(materialBlue100)
            .clickable {
                expanded = expanded.not()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(Icons.TwoTone.DateRange, contentDescription = "")
    }
}


@Composable
private fun Expanded() {
    Box(
        modifier = Modifier
            .size(300.dp)
            .clip(RectangleShape)
            .background(materialBlue100)
            .clickable {
                expanded = expanded.not()
            }
    ) {
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ut sem sapien. Nullam congue leo elit, sit amet ultrices elit.")
    }
}