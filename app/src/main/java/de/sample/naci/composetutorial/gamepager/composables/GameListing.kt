package de.sample.naci.composetutorial.gamepager.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import de.sample.naci.composetutorial.gamepager.data.model.GamesResponse
import de.sample.naci.composetutorial.gamepager.data.model.Result
import kotlinx.coroutines.flow.Flow
import kotlin.random.Random

@ExperimentalFoundationApi
@Composable
fun GameListing(
    games: Flow<PagingData<Result>>
) {
    val lazyGameItems = games.collectAsLazyPagingItems()
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(lazyGameItems.itemCount) { index ->
                val color: Color = remember{
                    Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
                }

                lazyGameItems[index]?.let {
//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(color),
//                        text = it.name.orEmpty(),
//                        color = Color.Black
//                    )

                    GameItem(game = it)
                }
            }
        }
    )
}