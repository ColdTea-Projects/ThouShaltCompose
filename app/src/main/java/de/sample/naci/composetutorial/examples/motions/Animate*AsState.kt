package de.sample.naci.composetutorial.examples

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring.DampingRatioHighBouncy
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.sample.naci.composetutorial.examples.motions.UpdateTransitionsDemo
import de.sample.naci.composetutorial.ui.theme.Purple500
import kotlin.random.Random

//animate*AsState functions for Float, Color, Dp, Size, Bounds, Offset, Rect, Int, IntOffset, and IntSize.

@Composable
fun AnimateSomethingAsState() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
        animationSpec =
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
//        spring(
//            dampingRatio = DampingRatioHighBouncy
//        )
//        keyframes {
//            durationMillis = 3000
//            sizeState at 0 with LinearEasing
//            sizeState * 1.5f at 800 with FastOutLinearInEasing
//            sizeState * 2f at 3000
//
//        }
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Purple500,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 5000)
        )
    )
    Box(
        modifier = Modifier
            .background(color)
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { sizeState += 50.dp }) {
            Text(text = "Increase Size")
        }
    }
}


@Preview
@Composable
fun AnimateSomethingAsStatePrvw(){
    AnimateSomethingAsState()
}