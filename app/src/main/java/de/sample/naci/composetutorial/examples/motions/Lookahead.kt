package de.sample.naci.composetutorial.examples.motions

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LookaheadLayoutDemo(){
    LookaheadLayout(
        content = {
            var fullWidth by remember { mutableStateOf(false) }
            Row(
                (if (fullWidth) Modifier.fillMaxWidth() else Modifier.width(100.dp))
                    .height(200.dp)
                    .animateConstraints(this@LookaheadLayout)
                    .animatePlacementInScope(this@LookaheadLayout)
                    .clickable { fullWidth = !fullWidth }) {
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red)
                )
                Box(
                    Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(Color.Yellow)
                )
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val maxWidth: Int = placeables.maxOf { it.width }
        val maxHeight = placeables.maxOf { it.height }
        // Position the children.
        layout(maxWidth, maxHeight) {
            placeables.forEach {
                it.place(0, 0)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.animateConstraints(lookaheadScope: LookaheadLayoutScope) = composed {
    var sizeAnimation: Animatable<IntSize, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }
    var targetSize: IntSize? by remember { mutableStateOf(null) }
    // Create a `LaunchEffect` to handle target size change. This avoids creating side effects
    // from measure/layout phase.
    LaunchedEffect(Unit) {
        snapshotFlow { targetSize }.collect { target ->
            if (target != null && target != sizeAnimation?.targetValue) {
                sizeAnimation?.run {
                    launch { animateTo(target) }
                } ?: Animatable(target, IntSize.VectorConverter).let {
                    sizeAnimation = it
                }
            }
        }
    }
    with(lookaheadScope) {
        // The measure logic in `intermediateLayout` is skipped in the lookahead pass, as
        // intermediateLayout is expected to produce intermediate stages of a layout transform.
        // When the measure block is invoked after lookahead pass, the lookahead size of the
        // child will be accessible as a parameter to the measure block.
        this@composed.intermediateLayout { measurable, _, lookaheadSize ->
            // When layout changes, the lookahead pass will calculate a new final size for the
            // child modifier. This lookahead size can be used to animate the size
            // change, such that the animation starts from the current size and gradually
            // change towards `lookaheadSize`.
            targetSize = lookaheadSize
            // Reads the animation size if the animation is set up. Otherwise (i.e. first
            // frame), use the lookahead size without animation.
            val (width, height) = sizeAnimation?.value ?: lookaheadSize
            // Creates a fixed set of constraints using the animated size
            val animatedConstraints = Constraints.fixed(width, height)
            // Measure child/children with animated constraints.
            val placeable = measurable.measure(animatedConstraints)
            layout(placeable.width, placeable.height) {
                placeable.place(0, 0)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.animatePlacementInScope(lookaheadScope: LookaheadLayoutScope) = composed {
    var offsetAnimation: Animatable<IntOffset, AnimationVector2D>? by remember {
        mutableStateOf(
            null
        )
    }

    var placementOffset: IntOffset by remember { mutableStateOf(IntOffset.Zero) }
    var targetOffset: IntOffset? by remember {
        mutableStateOf(null)
    }
    // Create a `LaunchEffect` to handle target size change. This avoids creating side effects
    // from measure/layout phase.
    LaunchedEffect(Unit) {
        snapshotFlow {
            targetOffset
        }.collect { target ->
            if (target != null && target != offsetAnimation?.targetValue) {
                offsetAnimation?.run {
                    launch { animateTo(target) }
                } ?: Animatable(target, IntOffset.VectorConverter).let {
                    offsetAnimation = it
                }
            }
        }
    }
    with(lookaheadScope) {
        this@composed
            .onPlaced { lookaheadScopeCoordinates, layoutCoordinates ->
                // This block of code has the LookaheadCoordinates of the LookaheadLayout
                // as the first parameter, and the coordinates of this modifier as the second
                // parameter.

                // localLookaheadPositionOf returns the *target* position of this
                // modifier in the LookaheadLayout's local coordinates.
                targetOffset = lookaheadScopeCoordinates.localLookaheadPositionOf(
                    layoutCoordinates
                ).round()
                // localPositionOf returns the *current* position of this
                // modifier in the LookaheadLayout's local coordinates.
                placementOffset = lookaheadScopeCoordinates.localPositionOf(
                    layoutCoordinates, Offset.Zero
                ).round()
            }
            // The measure logic in `intermediateLayout` is skipped in the lookahead pass, as
            // intermediateLayout is expected to produce intermediate stages of a layout
            // transform. When the measure block is invoked after lookahead pass, the lookahead
            // size of the child will be accessible as a parameter to the measure block.
            .intermediateLayout { measurable, constraints, _ ->
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    // offsetAnimation will animate the target position whenever it changes.
                    // In order to place the child at the animated position, we need to offset
                    // the child based on the target and current position in LookaheadLayout.
                    val (x, y) = offsetAnimation?.run { value - placementOffset }
                    // If offsetAnimation has not been set up yet (i.e. in the first frame),
                    // skip the animation
                        ?: (targetOffset!! - placementOffset)
                    placeable.place(x, y)
                }
            }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LookaheadLayoutDemoPreview(){
    LookaheadLayoutDemo()
}