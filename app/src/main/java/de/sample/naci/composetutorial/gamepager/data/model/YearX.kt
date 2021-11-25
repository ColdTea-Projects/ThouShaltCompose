package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YearX(
    @SerialName("count")
    var count: Int?,
    @SerialName("nofollow")
    var nofollow: Boolean?,
    @SerialName("year")
    var year: Int?
)