package com.example.cryptoapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.models.Crypto


class FavoriteViewModel : ViewModel() {
    private val _favorites = mutableStateListOf<Crypto>()
    val favorites: List<Crypto> get() = _favorites

    fun addToFavorites(crypto: Crypto) {
        _favorites.add(crypto)
    }

    fun removeFromFavorites(crypto: Crypto) {
        _favorites.remove(crypto)
    }
}