package com.omiwrench.homes.feature.listings.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.savedstate.SavedStateRegistry
import kotlinx.serialization.Serializable
import java.net.URL

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

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ListingDetailScreen(
        state = rememberScreenState(uiState)
    )
}

@Composable
private fun rememberScreenState(
    uiState: ListingDetailViewModel.UiState
) = remember(uiState) {
    with(uiState) {
        ScreenState(
            image = listing?.image,
            title = listing?.title,
            isLoading = false,
            hasFailure = false
        )
    }
}

internal data class ScreenState(
    val image: URL?,
    val title: String?,
    val isLoading: Boolean,
    val hasFailure: Boolean
)