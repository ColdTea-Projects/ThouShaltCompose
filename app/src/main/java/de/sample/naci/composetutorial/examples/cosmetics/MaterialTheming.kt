package de.sample.naci.composetutorial.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import de.sample.naci.composetutorial.ui.theme.DarkColors
import de.sample.naci.composetutorial.ui.theme.LightColors

@Composable
fun MaterialPlayground() {
    MaterialTheme(colors = if (isSystemInDarkTheme()) DarkColors else LightColors) {

        val materialColors = MaterialTheme.colors
        Scaffold(
            drawerContent = {
                Box(
                    Modifier
                        .fillMaxSize()
                ) {
                    Text(text = "This is the drawer", color = materialColors.primary)

                }
            },
            topBar = {
                TopAppBar(
                    title = { Text("TopAppBar") },
                    modifier = Modifier.background(color = materialColors.primaryVariant)
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    FloatingActionButton(onClick = {}) {
                        Text("FAB")
                    }
                }
            },
            content = { Text("BodyContent") },
            bottomBar = { BottomAppBar(modifier = Modifier.background(color = materialColors.primaryVariant)) { Text(text = "BottomAppBar") } }
        )
    }

}