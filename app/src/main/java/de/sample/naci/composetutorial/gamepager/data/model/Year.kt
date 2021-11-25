package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Year(
    @SerialName("count")
    var count: Int?,
    @SerialName("decade")
    var decade: Int?,
    @SerialName("filter")
    var filter: String?,
    @SerialName("from")
    var from: Int?,
    @SerialName("nofollow")
    var nofollow: Boolean?,
    @SerialName("to")
    var to: Int?,
    @SerialName("years")
    var years: List<YearX>?
)