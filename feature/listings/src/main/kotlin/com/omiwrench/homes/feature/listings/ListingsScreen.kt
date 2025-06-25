package com.omiwrench.homes.feature.listings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
internal fun ListingsScreen(
    state: ScreenState
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(state.listings) {
            when(it) {
                is ListingItem.Property -> {
                    Text("Property, ${it.streetAddress}")
                }
                is ListingItem.Area -> {
                    Text("Area, ${it.area}")
                }
            }
        }
    }

}