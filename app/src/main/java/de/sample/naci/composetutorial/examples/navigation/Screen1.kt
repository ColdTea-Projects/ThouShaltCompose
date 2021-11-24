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
import de.sample.naci.composetutorial.MainViewModel
import de.sample.naci.composetutorial.examples.stationaries.StaggeredGridDemo

@Composable
fun Screen1(navController: NavController, viewModel: MainViewModel) {
    Column(verticalArrangement = Arrangement.Top) {
        Row {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                navController.navigate("2/this is a sample test for passing arguments"){
                    popUpTo("1")
                }
            }) {
                Text(text = viewModel.nextScreenText)
            }
        }
        Row {
            StaggeredGridDemo()
        }
    }
}