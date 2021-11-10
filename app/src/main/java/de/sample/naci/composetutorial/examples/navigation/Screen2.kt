package de.sample.naci.composetutorial.navigation

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import de.sample.naci.composetutorial.MainViewModel
import de.sample.naci.composetutorial.examples.FullFledgedScaffold
import de.sample.naci.composetutorial.examples.motions.draganddroplist.DragDropList
import de.sample.naci.composetutorial.examples.motions.draganddroplist.ReorderItem
import de.sample.naci.composetutorial.examples.stationaries.StaggeredGridDemo
import de.sample.naci.composetutorial.extensions.swap

@Composable
fun Screen2(
    navController: NavController,
    text: String
) {
    Column(verticalArrangement = Arrangement.Top) {
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                navController.navigate("1")
            }) {
                Text(text = "Navigate previous")
            }
        }
        Row {
            FullFledgedScaffold(text)
        }
    }
}