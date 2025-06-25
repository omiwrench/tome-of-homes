package com.omiwrench.homes.repository.listing.model

import java.net.URL

sealed class Listing(open val id: String) {
    data class Property(
        override val id: String,
        val type: Type,
        val askingPrice: String,
        val monthlyFee: String,
        val municipality: String,
        val area: String,
        val daysOnMarket: Int,
        val livingArea: Int,
        val numberOfRooms: Int,
        val streetAddress: String,
        val image: URL,
    ): Listing(id = id) {
        enum class Type {
            Standard,
            Highlighted
        }
    }

    data class Area(
        override val id: String,
        val area: String,
        val rating: String,
        val averagePrice: String,
        val image: URL,
    ): Listing(id = id)
}