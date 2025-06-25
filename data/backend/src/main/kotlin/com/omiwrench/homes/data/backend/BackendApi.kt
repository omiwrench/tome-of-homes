package com.omiwrench.homes.data.backend

import com.omiwrench.homes.data.backend.model.response.ApiListingsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.resources.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackendApi @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getListings(): ApiListingsResponse = withContext(Dispatchers.IO) {
        httpClient.get(Listings).body()
    }
}

@Resource("/listings")
private object Listings