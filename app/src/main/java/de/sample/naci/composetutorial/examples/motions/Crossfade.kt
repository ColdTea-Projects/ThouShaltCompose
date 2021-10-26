package de.sample.naci.composetutorial.examples.motions

import android.widget.EditText
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp

enum class MyColors(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}

@Composable
fun CrossfadeDemo() {
    var currentColor by remember { mutableStateOf(MyColors.Red) }
    Column {
        Row {
            MyColors.values().forEach { myColors ->
                Button(
                    onClick = { currentColor = myColors },
                    Modifier
                        .weight(1f, true)
                        .height(48.dp)
                        .background(myColors.color),
                    colors = ButtonDefaults.buttonColors(backgroundColor = myColors.color)
                ) {
                    Text(myColors.name)
                }
            }

        }
        Crossfade(targetState = currentColor, animationSpec = tween(3000)) { selectedColor ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(selectedColor.color)
            )
        }


    }
}

enum class MyScreens() {
    First, Second, Third
}

@Composable
fun CrossfadeDemo2() {
    var currentScreen by remember { mutableStateOf(MyScreens.First) }

    Column {
        Row {
            MyScreens.values().forEach { screen ->
                Button(
                    onClick = { currentScreen = screen },
                    Modifier
                        .weight(1f, true)
                        .height(48.dp),
                ) {
                    Text(screen.name)
                }
            }
        }

        Crossfade(targetState = currentScreen, animationSpec = tween(2000)) { screen ->
            when (screen) {
                MyScreens.First -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text(text = "First Screen")
                    }
                }
                MyScreens.Second -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TextField(value = "SUp", onValueChange = {}, modifier = Modifier.fillMaxWidth())
                        Text(text = "Hellow crossfade")
                    }
                }
                MyScreens.Third -> {

                }
            }
        }
    }
}