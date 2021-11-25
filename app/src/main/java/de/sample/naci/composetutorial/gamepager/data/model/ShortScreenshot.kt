package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortScreenshot(
    @SerialName("id")
    var id: Int?,
    @SerialName("image")
    var image: String?
)