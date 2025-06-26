package com.omiwrench.homes.feature.listings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.savedstate.SavedStateRegistry
import com.omiwrench.homes.repository.listing.model.Listing
import kotlinx.serialization.Serializable
import java.net.URL

@Serializable
data object Listings

@Composable
fun ListingsRoute(
    savedStateRegistry: SavedStateRegistry,
    viewModel: ListingsViewModel = hiltViewModel(
        creationCallback = { factory: ListingsViewModel.Factory ->
            factory.create(savedStateRegistry = savedStateRegistry)
        }
    ),
    onListingClick: (id: String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ListingsScreen(
        state = rememberScreenState(uiState),
        onListingClick = { onListingClick(it.id) }
    )
}

@Composable
private fun rememberScreenState(
    uiState: ListingsViewModel.UiState
) = remember(uiState) {
    ScreenState(
        listings = uiState.listings.orEmpty().map {
            it.asListingItem()
        },
        isLoading = uiState.isLoading,
        hasFailure = uiState.hasFailure
    )
}

internal fun Listing.asListingItem() = when(this) {
    is Listing.Area -> {
        ListingItem.Area(
            id = id,
            image = image,
            area = area,
            rating = rating,
            averagePrice = averagePrice
        )
    }
    is Listing.Property -> {
        ListingItem.Property(
            id = id,
            image = image,
            streetAddress = streetAddress,
            area = area,
            municipality = municipality,
            askingPrice = askingPrice,
            livingArea = livingArea,
            numberOfRooms = numberOfRooms,
            daysOnMarket = daysOnMarket,
            isHighlighted = type == Listing.Property.Type.Highlighted
        )
    }
}

internal data class ScreenState(
    val listings: List<ListingItem>,
    val isLoading: Boolean,
    val hasFailure: Boolean
) {
    companion object {
        fun preview() = ScreenState(
            listings = listOf(
                ListingItem.Property(
                    id = "1",
                    image = URL("https://upload.wikimedia.org/wikipedia/commons/8/8f/Arkitekt_Peder_Magnussen_hus_H%C3%B8nefoss_HDR.jpg"),
                    streetAddress = "Vägvägen 123",
                    area = "Vägholma",
                    municipality = "Stockholm",
                    askingPrice = "5 000 000 kr",
                    livingArea = 80,
                    numberOfRooms = 5,
                    daysOnMarket = 123,
                    isHighlighted = false
                ),
                ListingItem.Property(
                    id = "2",
                    image = URL("https://upload.wikimedia.org/wikipedia/commons/8/8f/Arkitekt_Peder_Magnussen_hus_H%C3%B8nefoss_HDR.jpg"),
                    streetAddress = "Vägvägen 1234",
                    area = "Vägholma",
                    municipality = "Stockholm",
                    askingPrice = "10 000 000 kr",
                    livingArea = 160,
                    numberOfRooms = 10,
                    daysOnMarket = 1234,
                    isHighlighted = true
                ),
                ListingItem.Area(
                    id = "12345",
                    image = URL("https://upload.wikimedia.org/wikipedia/commons/8/8f/Arkitekt_Peder_Magnussen_hus_H%C3%B8nefoss_HDR.jpg"),
                    area = "Stockholm",
                    rating = "5/5",
                    averagePrice = "12 000 000 kr"
                )
            ),
            isLoading = false,
            hasFailure = false
        )
    }
}