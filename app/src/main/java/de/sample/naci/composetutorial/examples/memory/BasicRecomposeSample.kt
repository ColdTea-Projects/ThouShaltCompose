package de.sample.naci.composetutorial.examples.memory

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextBoxToRecompose(clicks: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Text(
        "This is clicked $clicks time",
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}