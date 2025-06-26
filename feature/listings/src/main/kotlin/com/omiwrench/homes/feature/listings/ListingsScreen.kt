package com.omiwrench.homes.feature.listings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.omiwrench.homes.library.ui.theme.HighlightBorder
import com.omiwrench.homes.library.ui.theme.HighlightPill
import com.omiwrench.homes.library.ui.theme.TomeOfHomesTheme
import timber.log.Timber
import java.net.URL

@Composable
internal fun ListingsScreen(
    state: ScreenState,
    onListingClick: (ListingItem) -> Unit
) {
    Scaffold { contentPadding ->
        when {
            state.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            state.hasFailure -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Outlined.ErrorOutline,
                        contentDescription = "Error",
                        tint = Color.Red
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.padding(contentPadding),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(state.listings) {
                        ListingContainer(
                            title = it.title,
                            imageUrl = it.image,
                            isHighlighted = (it as? ListingItem.Property)?.isHighlighted == true,
                            footer = { it.Footer() },
                            imageDecoration = { it.ImageDecoration() },
                            onClick = { onListingClick(it) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ListingContainer(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: URL,
    isHighlighted: Boolean,
    footer: @Composable () -> Unit,
    imageDecoration: @Composable BoxScope.() -> Unit = {},
    onClick: () -> Unit
) {
    val borderColor = if (isHighlighted) HighlightBorder else Color.Black
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, borderColor),
        onClick = onClick,
    ) {
        Box {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                model = imageUrl.toString(),
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray)
                    )
                },
                onError = {
                    Timber.e(it.result.throwable, "Error loading image")
                },
                contentScale = ContentScale.FillWidth,
                contentDescription = "listing image"
            )
            imageDecoration()
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title)
            footer()
        }
    }
}

@Composable
private fun ListingItem.Footer() {
    when (this) {
        is ListingItem.Area -> {
            Text(
                text = stringResource(R.string.listings_area_averagePrice_format, averagePrice),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        is ListingItem.Property -> {
            Text(
                text = stringResource(
                    R.string.listings_property_locationSubtitle_format,
                    area,
                    municipality
                ),
                style = MaterialTheme.typography.titleSmall
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = askingPrice
                )
                Text(
                    text = stringResource(R.string.listings_property_livingArea_format, livingArea)
                )
                Text(
                    text = stringResource(R.string.listings_property_rooms_format, numberOfRooms)
                )
                Text(
                    text = stringResource(R.string.listings_property_days_format, daysOnMarket)
                )
            }
        }
    }
}

@Composable
private fun ListingItem.ImageDecoration() {
    Box(modifier = Modifier.padding(16.dp)) {
        when (this@ImageDecoration) {
            is ListingItem.Property -> {
                if (isHighlighted) {
                    Pill(
                        text = stringResource(R.string.listings_property_highlighted_pill),
                        color = HighlightPill
                    )
                }
            }

            is ListingItem.Area -> {
                Pill(
                    text = stringResource(R.string.listings_area_rating_format, rating),
                    color = HighlightPill
                )
            }
        }
    }
}

@Composable
private fun Pill(
    text: String,
    color: Color
) {
    Box(
        modifier = Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(percent = 100)
            )
            .padding(6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White
        )
    }
}

@Composable
@Preview
private fun ListingsScreenPreview() {
    TomeOfHomesTheme {
        ListingsScreen(
            state = ScreenState.preview(),
            onListingClick = {}
        )
    }
}