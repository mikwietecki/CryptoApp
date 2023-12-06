package com.example.cryptoapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FavoritesScreen(
    favoriteViewModel: FavoriteViewModel = viewModel()
) {
    Column {
        Text(
            text = "Favorite Cryptocurrencies",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            items(favoriteViewModel.favorites) { crypto ->
                Log.d("FavoritesScreen", "Crpyto: $crypto")
                Crypto(crypto = crypto, favoriteViewModel = favoriteViewModel)
            }
        }
    }
}