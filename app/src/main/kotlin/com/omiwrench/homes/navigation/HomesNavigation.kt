package com.omiwrench.homes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omiwrench.homes.feature.listings.ListingsRoute
import kotlinx.serialization.Serializable

@Serializable
data object Listings

@Serializable
data class ListingDetail(val id: String)

@Composable
fun HomesNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Listings) {
        composable<Listings> {
            ListingsRoute(savedStateRegistry = it.savedStateRegistry)
        }
        composable<ListingDetail> {

        }
    }
}