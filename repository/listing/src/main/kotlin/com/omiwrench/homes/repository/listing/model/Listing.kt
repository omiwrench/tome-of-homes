package com.omiwrench.homes.repository.listing.model

import java.net.URL

sealed class Listing(
    open val id: String,
    open val image: URL,
    val title: String
) {
    data class Property(
        override val id: String,
        override val image: URL,
        val type: Type,
        val askingPrice: String,
        val monthlyFee: String,
        val municipality: String,
        val area: String,
        val daysOnMarket: Int,
        val livingArea: Int,
        val numberOfRooms: Int,
        val streetAddress: String,
    ): Listing(
        id = id,
        image = image,
        title = streetAddress
    ) {
        enum class Type {
            Standard,
            Highlighted
        }
    }

    data class Area(
        override val id: String,
        override val image: URL,
        val area: String,
        val rating: String,
        val averagePrice: String,
    ): Listing(
        id = id,
        image = image,
        title = area
    )
}