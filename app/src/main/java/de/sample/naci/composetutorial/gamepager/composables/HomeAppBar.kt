package de.sample.naci.composetutorial.gamepager.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeAppBar(
    title: String,
    openSearch: () -> Unit,
    openFilters: () -> Unit,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = openSearch) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = openFilters) {
                Icon(imageVector = Icons.Filled.List, contentDescription = "Filter")
            }
        }
    )
}