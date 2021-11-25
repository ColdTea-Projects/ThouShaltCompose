package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("games_count")
    var gamesCount: Int?,
    @SerialName("id")
    var id: Int?,
    @SerialName("image_background")
    var imageBackground: String?,
    @SerialName("language")
    var language: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("slug")
    var slug: String?
)