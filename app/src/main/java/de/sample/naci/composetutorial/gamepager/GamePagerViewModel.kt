package de.sample.naci.composetutorial.gamepager

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import de.sample.naci.composetutorial.gamepager.data.GamesRepository.Companion.PAGE_SIZE
import de.sample.naci.composetutorial.gamepager.data.GamesSource
import de.sample.naci.composetutorial.gamepager.data.model.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GamePagerViewModel @Inject constructor(
    private val gamesSource: GamesSource
): ViewModel() {

    fun getAllGames(): Flow<PagingData<Result>> {
        return Pager(PagingConfig(PAGE_SIZE)) { gamesSource }.flow
    }
}