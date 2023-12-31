package com.example.cryptoapp.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.models.Crypto


class FavoriteViewModel : ViewModel() {
    private val _favorites = mutableStateListOf<Crypto>()
    val favorites: List<Crypto> get() = _favorites.toList()

    fun addToFavorites(crypto: Crypto) {
        _favorites.add(crypto)
        println("Added to favorites: $crypto")
    }

    fun removeFromFavorites(crypto: Crypto) {
        _favorites.remove(crypto)
        println("Removed from favorites: $crypto")
    }
}