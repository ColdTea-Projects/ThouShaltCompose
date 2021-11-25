package de.sample.naci.composetutorial.gamepager.data

import de.sample.naci.composetutorial.BuildConfig
import de.sample.naci.composetutorial.gamepager.data.model.GamesResponse
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val gamesApi: GamesApi
) {
    suspend fun getGames(page: Int): GamesResponse? = gamesApi.getGames(BuildConfig.API_KEY_GAMES, page = page, pageSize = PAGE_SIZE)

    companion object{
        const val PAGE_SIZE = 50
    }
}