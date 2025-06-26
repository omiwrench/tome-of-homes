package com.omiwrench.homes.feature.listings.detail

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

@HiltViewModel(assistedFactory = ListingDetailViewModel.Factory::class)
class ListingDetailViewModel @AssistedInject constructor(
    @Assisted savedStateRegistry: SavedStateRegistry,
    @Assisted private val listingId: String,
    private val listingRepository: ListingRepository
): MoleculeViewModel<ListingDetailViewModel.UiState>() {

    @AssistedFactory
    interface Factory {
        fun create(
            savedStateRegistry: SavedStateRegistry,
            listingId: String
        ): ListingDetailViewModel
    }

    @Composable
    override fun uiState(): UiState {
        val listing by produceState<Result<Listing>?>(null) {
            value = listingRepository.getListing(listingId)
        }

        return UiState(
            listing = listing?.getOrNull()
        )
    }

    data class UiState(
        val listing: Listing?
    )
}