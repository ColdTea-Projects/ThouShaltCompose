package de.sample.naci.composetutorial.gamepager.data

import de.sample.naci.composetutorial.gamepager.data.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("api/games")
    suspend fun getGames(@Query("key") key: String, @Query("page") page: Int, @Query("page_size") pageSize: Int): GamesResponse?
}