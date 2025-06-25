package com.omiwrench.homes.data.backend

import com.omiwrench.homes.data.backend.model.ApiListing
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackendApi @Inject constructor(
    //private val httpClient: HttpClient
) {

    suspend fun getListings(): List<ApiListing> = withContext(Dispatchers.IO) {
        testListings
    }

}

private val testListings: List<ApiListing>
    get() = listOf(
        ApiListing.HighlightedProperty(
            id = "1234",
            askingPrice = "1 million dolla",
            monthlyFee = "231",
            municipality = "Stockholm",
            area = "Johannesfred",
            daysOnHemnet = 12,
            livingArea = 100,
            numberOfRooms = 2,
            streetAddress = "Bingusvägen 23",
            image = "https://http.cat/images/102.jpg"
        ),
        ApiListing.Property(
            id = "12346",
            askingPrice = "1 dolla",
            monthlyFee = "2311",
            municipality = "Stockholm",
            area = "Johannesfred",
            daysOnHemnet = 43,
            livingArea = 24,
            numberOfRooms = 1,
            streetAddress = "Bingusvägen 10038",
            image = "https://http.cat/images/103.jpg"
        ),
        ApiListing.Area(
            id = "33331",
            area = "HERE",
            rating = "5/5",
            averagePrice = "A billi",
            image = "https://http.cat/images/104.jpg"
        )
    )