package com.omiwrench.homes.feature.listings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.savedstate.SavedStateRegistry
import com.omiwrench.homes.library.molecule.MoleculeViewModel
import com.omiwrench.homes.repository.listing.ListingRepository
import com.omiwrench.homes.repository.listing.model.Listing
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URL

@HiltViewModel(assistedFactory = ListingsViewModel.Factory::class)
class ListingsViewModel @AssistedInject constructor(
    @Assisted savedStateRegistry: SavedStateRegistry,
    private val listingRepository: ListingRepository
) : MoleculeViewModel<ListingsViewModel.UiState>() {

    @AssistedFactory
    interface Factory {
        fun create(savedStateRegistry: SavedStateRegistry): ListingsViewModel
    }

    @Composable
    override fun uiState(): UiState {
        val listings by produceState<Result<List<Listing>>?>(null) {
            value = listingRepository.fetchListings()
        }

        return UiState(
            listings = listings?.getOrNull(),
            isLoading = false,
            isRefreshing = false,
            hasError = listings?.isFailure == true
        )
    }

    data class UiState(
        val listings: List<Listing>?,
        val isLoading: Boolean = false,
        val isRefreshing: Boolean = false,
        val hasError: Boolean = false
    )
}

sealed class ListingItem(
    open val id: String,
    open val image: URL,
    val title: String,
) {
    data class Property(
        override val id: String,
        override val image: URL,
        val streetAddress: String,
        val area: String,
        val municipality: String,
        val askingPrice: String,
        val livingArea: Int,
        val numberOfRooms: Int,
        val daysOnMarket: Int,
        val isHighlighted: Boolean = false
    ) : ListingItem(id, image, streetAddress)

    data class Area(
        override val id: String,
        override val image: URL,
        val area: String,
        val rating: String,
        val averagePrice: String
    ) : ListingItem(id, image, area)
}