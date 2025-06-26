package com.omiwrench.homes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.omiwrench.homes.feature.listings.Listings
import com.omiwrench.homes.feature.listings.ListingsRoute
import com.omiwrench.homes.feature.listings.detail.ListingDetail
import com.omiwrench.homes.feature.listings.detail.ListingDetailRoute

@Composable
fun HomesNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Listings) {
        composable<Listings> {
            ListingsRoute(
                savedStateRegistry = it.savedStateRegistry,
                onListingClick = { id ->
                    navController.navigate(ListingDetail(id))
                }
            )
        }
        composable<ListingDetail> { backStackEntry ->
            val listingDetail: ListingDetail = backStackEntry.toRoute()
            ListingDetailRoute(
                savedStateRegistry = backStackEntry.savedStateRegistry,
                listingId = listingDetail.id
            )
        }
    }
}