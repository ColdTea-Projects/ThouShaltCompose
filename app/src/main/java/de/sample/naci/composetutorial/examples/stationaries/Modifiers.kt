package de.sample.naci.composetutorial.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Modifiers() =
    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxHeight(0.5f)
            .width(600.dp)
            .padding(20.dp)
            .border(5.dp, Color.Magenta)
            .padding(15.dp)
            .border(5.dp, Color.Red)
            .padding(15.dp)
            .border(5.dp, Color.White)
//            .requiredWidth(600.dp)//forces even when it is bigger than the screen
    ) {
        Text(
            "Hello",
            modifier = Modifier
                .offset(50.dp, 20.dp)
                .clickable {

                }
            )
        Spacer(modifier = Modifier.height(50.dp))
        Text("Compose")
    }