package com.example.cryptoapp.ui.theme


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon:ImageVector
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
            icon = Icons.Default.Home,

    )

    object Favorites: BottomBarScreen(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Default.Favorite
    )

    object Settings: BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

}