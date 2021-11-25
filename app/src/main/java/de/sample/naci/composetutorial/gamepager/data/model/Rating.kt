package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    @SerialName("count")
    var count: Int?,
    @SerialName("id")
    var id: Int?,
    @SerialName("percent")
    var percent: Double?,
    @SerialName("title")
    var title: String?
)