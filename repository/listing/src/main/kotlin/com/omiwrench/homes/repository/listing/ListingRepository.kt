package com.omiwrench.homes.repository.listing

import com.omiwrench.homes.data.backend.BackendApi
import com.omiwrench.homes.repository.listing.mapping.asListing
import com.omiwrench.homes.repository.listing.model.Listing
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListingRepository @Inject constructor(
    private val backend: BackendApi
) {

    suspend fun fetchListings(): Result<List<Listing>> = runCatching {
        backend.getListings().items.map {
            it.asListing()
        }
    }
}