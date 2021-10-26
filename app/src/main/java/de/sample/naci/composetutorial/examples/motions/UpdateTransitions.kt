package de.sample.naci.composetutorial.examples.motions

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateRect
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private enum class BoxState {
    Collapsed,
    Expanded
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UpdateTransitionsDemo(){
    var currentState by remember { mutableStateOf(BoxState.Collapsed) }
    val transition = updateTransition(currentState)

    val rect by transition.animateRect { state ->
        when (state) {
            BoxState.Collapsed -> Rect(0f, 0f, 100f, 100f)
            BoxState.Expanded -> Rect(100f, 100f, 300f, 300f)
        }
    }
    val borderWidth by transition.animateDp { state ->
        when (state) {
            BoxState.Collapsed -> 4.dp
            BoxState.Expanded -> 1.dp
        }
    }

    val color by transition.animateColor { state ->
        when (state) {
            BoxState.Collapsed -> MaterialTheme.colors.primary
            BoxState.Expanded -> MaterialTheme.colors.secondary
        }
    }

    val colorBck by transition.animateColor(
        transitionSpec = {
            when {
                BoxState.Expanded isTransitioningTo BoxState.Collapsed ->
                    spring(stiffness = 50f)
                else ->
                    tween(durationMillis = 500)
            }
        }, label = ""
    ) { state ->
        when (state) {
            BoxState.Collapsed -> MaterialTheme.colors.secondary
            BoxState.Expanded -> MaterialTheme.colors.primaryVariant
        }
    }

    Surface(
        onClick = { currentState = if(currentState == BoxState.Expanded) BoxState.Collapsed else BoxState.Expanded },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(borderWidth, color)
    ) {
        Box(modifier = Modifier
            .size(300.dp)
            .background(colorBck))
    }
}
