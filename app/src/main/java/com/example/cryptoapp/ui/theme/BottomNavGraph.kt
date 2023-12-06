package com.example.cryptoapp.ui.theme

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptoapp.screens.FavoritesScreen
import com.example.cryptoapp.screens.HomeScreen
import com.example.cryptoapp.screens.Settings

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            Settings()
        }
    }
}