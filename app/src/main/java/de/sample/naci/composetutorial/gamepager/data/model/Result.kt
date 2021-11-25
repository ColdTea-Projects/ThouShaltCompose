package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("background_image")
    var backgroundImage: String?,
    @SerialName("clip")
    var clip: String?,
    @SerialName("dominant_color")
    var dominantColor: String?,
    @SerialName("esrb_rating")
    var esrbRating: EsrbRating?,
    @SerialName("genres")
    var genres: List<Genre>?,
    @SerialName("id")
    var id: Int?,
    @SerialName("metacritic")
    var metacritic: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("playtime")
    var playtime: Int?,
    @SerialName("rating")
    var rating: Double?,
    @SerialName("rating_top")
    var ratingTop: Int?,
    @SerialName("ratings")
    var ratings: List<Rating>?,
    @SerialName("ratings_count")
    var ratingsCount: Int?,
    @SerialName("released")
    var released: String?,
    @SerialName("reviews_count")
    var reviewsCount: Int?,
    @SerialName("reviews_text_count")
    var reviewsTextCount: Int?,
    @SerialName("saturated_color")
    var saturatedColor: String?,
    @SerialName("short_screenshots")
    var shortScreenshots: List<ShortScreenshot>?,
    @SerialName("suggestions_count")
    var suggestionsCount: Int?,
    @SerialName("tags")
    var tags: List<Tag>?,
    @SerialName("tba")
    var tba: Boolean?,
    @SerialName("updated")
    var updated: String?,
    @SerialName("user_game")
    var userGame: String?
)