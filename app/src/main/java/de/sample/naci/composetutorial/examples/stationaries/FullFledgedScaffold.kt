package de.sample.naci.composetutorial.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import de.sample.naci.composetutorial.ui.theme.Purple200
import kotlinx.coroutines.launch

@Composable
fun FullFledgedScaffold(
    text: String = "BodyContent"
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val composeScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Purple200)
            ) {
                Text(text = "This is the drawer")
            }
        },
        topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = Purple200)  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {
            composeScope.launch{
                    scaffoldState.drawerState.open()
            }
        }){
            Text(">")
        } },
        content = { Text(text) },
        bottomBar = { BottomAppBar(backgroundColor = Purple200) { Text("BottomAppBar") } }
    )
}