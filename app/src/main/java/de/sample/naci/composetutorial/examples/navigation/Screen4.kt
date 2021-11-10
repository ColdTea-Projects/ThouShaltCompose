package de.sample.naci.composetutorial.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import de.sample.naci.composetutorial.examples.stationaries.CanvasDemo

@Composable
fun Screen4(
    navController: NavController
) {
    Column(verticalArrangement = Arrangement.Top) {
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                navController.navigate("3")
            }) {
                Text(text = "Navigate to 3")
            }
        }
        Row {
            CanvasDemo()
        }
    }
}