package de.sample.naci.composetutorial.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ColumnsAndRows() =
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Text("Hello")
            Text("Compose")
        }
        Row() {
            Text("Hello")
            Text("Kotlin")
        }

    }
