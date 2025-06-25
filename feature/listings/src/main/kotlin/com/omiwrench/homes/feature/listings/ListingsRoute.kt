package com.omiwrench.homes.feature.listings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.savedstate.SavedStateRegistry
import com.omiwrench.homes.repository.listing.model.Listing
import kotlinx.serialization.Serializable

@Serializable
data object Listings

@Composable
fun ListingsRoute(
    savedStateRegistry: SavedStateRegistry,
    viewModel: ListingsViewModel = hiltViewModel(
        creationCallback = { factory: ListingsViewModel.Factory ->
            factory.create(savedStateRegistry = savedStateRegistry)
        }
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ListingsScreen(
        state = rememberScreenState(uiState)
    )
}

internal data class ScreenState(
    val listings: List<ListingItem>,
    val isLoading: Boolean,
    val isRefreshing: Boolean
)

@Composable
private fun rememberScreenState(
    uiState: ListingsViewModel.UiState
) = remember(uiState) {
    ScreenState(
        listings = uiState.listings.orEmpty().map {
            it.asListingItem()
        },
        isLoading = uiState.isLoading,
        isRefreshing = uiState.isRefreshing
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
            generalLocation = "${this.area}, ${this.municipality}",
            askingPrice = askingPrice,
            livingArea = livingArea,
            numberOfRooms = numberOfRooms,
            daysOnMarket = daysOnMarket,
            isHighlighted = type == Listing.Property.Type.Highlighted
        )
    }
}