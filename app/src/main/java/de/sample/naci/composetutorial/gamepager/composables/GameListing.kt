package de.sample.naci.composetutorial.gamepager.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import de.sample.naci.composetutorial.gamepager.data.model.Result
import kotlinx.coroutines.flow.Flow

@ExperimentalFoundationApi
@Composable
fun GameListing(
    games: Flow<PagingData<Result>>,
    modifier: Modifier = Modifier
) {
    val lazyGameItems = games.collectAsLazyPagingItems()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        content = {
            items(lazyGameItems.itemCount) { index ->
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