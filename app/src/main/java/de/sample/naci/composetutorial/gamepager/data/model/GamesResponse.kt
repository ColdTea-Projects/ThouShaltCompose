package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamesResponse(
    @SerialName("count")
    var count: Int?,
    @SerialName("description")
    var description: String?,
    @SerialName("filters")
    var filters: Filters?,
    @SerialName("next")
    var next: String?,
    @SerialName("nofollow")
    var nofollow: Boolean?,
    @SerialName("nofollow_collections")
    var nofollowCollections: List<String>?,
    @SerialName("noindex")
    var noindex: Boolean?,
    @SerialName("previous")
    var previous: String?,
    @SerialName("results")
    var results: List<Result>?,
    @SerialName("seo_description")
    var seoDescription: String?,
    @SerialName("seo_h1")
    var seoH1: String?,
    @SerialName("seo_keywords")
    var seoKeywords: String?,
    @SerialName("seo_title")
    var seoTitle: String?
)