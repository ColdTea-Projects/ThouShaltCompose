package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddedByStatus(
    @SerialName("beaten")
    var beaten: Int?,
    @SerialName("dropped")
    var dropped: Int?,
    @SerialName("owned")
    var owned: Int?,
    @SerialName("playing")
    var playing: Int?,
    @SerialName("toplay")
    var toplay: Int?,
    @SerialName("yet")
    var yet: Int?
)