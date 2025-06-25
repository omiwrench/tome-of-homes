package com.omiwrench.homes.data.backend.model.response

import com.omiwrench.homes.data.backend.model.ApiListing
import kotlinx.serialization.Serializable

@Serializable
data class ApiListingsResponse(
    val items: List<ApiListing>
)