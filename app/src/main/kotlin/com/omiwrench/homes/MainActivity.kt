package com.omiwrench.homes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.omiwrench.homes.library.ui.theme.TomeOfHomesTheme
import com.omiwrench.homes.navigation.HomesNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TomeOfHomesTheme {
                HomesNavigation()
            }
        }
    }
}