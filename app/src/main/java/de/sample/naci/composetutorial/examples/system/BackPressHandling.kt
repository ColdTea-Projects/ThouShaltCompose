package de.sample.naci.composetutorial.examples.system

import androidx.activity.compose.BackHandler
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

@Composable
fun BackPressHandler(){
    var backPressedCount by remember { mutableStateOf(0) }
    BackHandler(enabled = true, onBack = {
        backPressedCount += 1
    })
    Text(text="Backbutton was pressed : $backPressedCount times")
}