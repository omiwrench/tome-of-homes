package com.omiwrench.homes.repository.listing.mapping

import com.omiwrench.homes.data.backend.model.ApiListing
import com.omiwrench.homes.repository.listing.model.Listing
import java.net.URL

fun ApiListing.asListing() =
    when (this) {
        is ApiListing.Area -> Listing.Area(
            id = id,
            area = area,
            rating = rating,
            averagePrice = averagePrice,
            image = URL(image)
        )

        is ApiListing.Property -> Listing.Property(
            id = id,
            type = Listing.Property.Type.Standard,
            askingPrice = askingPrice,
            monthlyFee = monthlyFee,
            municipality = municipality,
            area = area,
            daysOnMarket = daysOnHemnet,
            livingArea = livingArea,
            numberOfRooms = numberOfRooms,
            streetAddress = streetAddress,
            image = URL(image),
        )
        is ApiListing.HighlightedProperty -> Listing.Property(
            id = id,
            type = Listing.Property.Type.Highlighted,
            askingPrice = askingPrice,
            monthlyFee = monthlyFee,
            municipality = municipality,
            area = area,
            daysOnMarket = daysOnHemnet,
            livingArea = livingArea,
            numberOfRooms = numberOfRooms,
            streetAddress = streetAddress,
            image = URL(image),
        )
    }