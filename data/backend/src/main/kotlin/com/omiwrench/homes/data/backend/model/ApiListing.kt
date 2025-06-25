package com.omiwrench.homes.data.backend.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ApiListing {
     abstract val id: String

     @Serializable
     @SerialName("Property")
     data class Property(
         override val id: String,
         val askingPrice: String,
         val monthlyFee: String,
         val municipality: String,
         val area: String,
         val daysOnHemnet: Int,
         val livingArea: Int,
         val numberOfRooms: Int,
         val streetAddress: String,
         val image: String
     ): ApiListing()

    @Serializable
    @SerialName("HighlightedProperty")
    data class HighlightedProperty(
        override val id: String,
        val askingPrice: String,
        val monthlyFee: String,
        val municipality: String,
        val area: String,
        val daysOnHemnet: Int,
        val livingArea: Int,
        val numberOfRooms: Int,
        val streetAddress: String,
        val image: String
    ): ApiListing()

    @Serializable
    @SerialName("Area")
    data class Area(
        override val id: String,
        val area: String,
        val rating: String,
        val averagePrice: String,
        val image: String,
    ): ApiListing()
}