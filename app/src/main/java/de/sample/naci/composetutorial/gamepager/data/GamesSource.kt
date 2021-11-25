package de.sample.naci.composetutorial.gamepager.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import de.sample.naci.composetutorial.gamepager.data.model.Result

class GamesSource(
    private val gamesRepository: GamesRepository
) : PagingSource<Int, Result>() {

    private var nextPage = 1

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Result> {
        nextPage = params.key ?: 1
        val results =
            gamesRepository.getGames(nextPage)?.results
        return if (results == null) {
            LoadResult.Error(
                Exception("Empty result")
            )
        } else {
            LoadResult.Page(
                data = results,
                prevKey =
                    if (nextPage == 1) null
                    else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return nextPage
    }
}