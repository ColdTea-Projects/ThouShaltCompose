package de.sample.naci.composetutorial.examples

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun States() {
    Column(Modifier.fillMaxSize()) {
        val color = remember{
            mutableStateOf(Color.Yellow)
        }
        ColorBox(Modifier.fillMaxSize().weight(1f), color = color)
        Box(Modifier.background(color.value).fillMaxSize().weight(1f))
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, color: MutableState<Color>) {

    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }
    )
}
