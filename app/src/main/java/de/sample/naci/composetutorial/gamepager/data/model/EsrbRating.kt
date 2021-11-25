package de.sample.naci.composetutorial.gamepager.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EsrbRating(
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("slug")
    var slug: String?
)