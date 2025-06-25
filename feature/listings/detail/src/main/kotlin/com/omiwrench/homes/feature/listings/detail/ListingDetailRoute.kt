package com.omiwrench.homes.feature.listings.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.savedstate.SavedStateRegistry
import kotlinx.serialization.Serializable

@Serializable
data class ListingDetail(val id: String)

@Composable
fun ListingDetailRoute(
    savedStateRegistry: SavedStateRegistry,
    listingId: String,
    viewModel: ListingDetailViewModel = hiltViewModel(
        creationCallback = { factory: ListingDetailViewModel.Factory ->
            factory.create(savedStateRegistry, listingId)
        }
    )
) {

}