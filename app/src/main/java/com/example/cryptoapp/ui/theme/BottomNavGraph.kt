package com.example.cryptoapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptoapp.screens.FavoriteViewModel
import com.example.cryptoapp.screens.FavoritesScreen
import com.example.cryptoapp.screens.HomeScreen
import com.example.cryptoapp.screens.Settings

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val favoriteViewModel: FavoriteViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(favoriteViewModel = favoriteViewModel)
        }
        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen(favoriteViewModel = favoriteViewModel)
        }
        composable(route = BottomBarScreen.Settings.route) {
            Settings()
        }
    }
}