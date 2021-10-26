package de.sample.naci.composetutorial.examples

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

var color by mutableStateOf(Color.Red)

@Composable
fun CompositionLocals() {
    @SuppressLint("CompositionLocalNaming")
    val ColorCompositionLocal = compositionLocalOf<Color> {
        error("No Color provided")
    }

    Column(modifier = Modifier.fillMaxHeight()) {
        CompositionLocalProvider(
            ColorCompositionLocal provides color,
            LocalContentAlpha provides ContentAlpha.disabled
        ) {
            Box(
                modifier = Modifier
                    .background(ColorCompositionLocal.current)
                    .fillMaxWidth()
            ) {
                Text(text = "WazSup bichaaz")
            }
        }
        Box(
            modifier = Modifier
                .background(color)
                .fillMaxWidth()
                .clickable(onClick = {
                    color = if (color == Color.Green) {
                        Color.Red
                    } else {
                        Color.Green
                    }
                })
        ) {
            Text(text = "Click Here")
        }
    }
}
