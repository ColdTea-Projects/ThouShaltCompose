package de.sample.naci.composetutorial.examples.stationaries

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun Shapes(){
    Column(modifier = Modifier.fillMaxSize().padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        //Rectangle
        Row() {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RectangleShape)
                    .background(Color.Green)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        //Circle
        Row() {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        //Rounded Corner
        Row() {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Red)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        //Cut Corner
        Row() {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CutCornerShape(10.dp))
                    .background(Color.Black)
            )

        }

    }
}