package de.sample.naci.composetutorial.gamepager.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun HomeAppBar(title: String, openSearch: () -> Unit, openFilters: () -> Unit) {
    TopAppBar(
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