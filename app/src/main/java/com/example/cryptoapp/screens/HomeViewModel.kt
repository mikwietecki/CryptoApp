package com.example.cryptoapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.models.ApiBaseModel
import com.example.cryptoapp.models.BaseModel
import com.example.cryptoapp.models.Crypto
import com.example.cryptoapp.models.CryptoCurrencyList
import com.example.cryptoapp.repository.CryptoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel:ViewModel(),KoinComponent {
    private val repo:CryptoRepo by inject()
    private val favoriteViewModel: FavoriteViewModel by inject()

    private val _response:MutableStateFlow<BaseModel<ApiBaseModel<CryptoCurrencyList>>?> = MutableStateFlow(null)
    val response = _response.asStateFlow()

    fun getListing() {
        viewModelScope.launch {
            _response.update { BaseModel.Loading }
            repo.getListing().also { res ->
                _response.update { res }
            }
        }
    }

    fun addToFavorites(crypto: Crypto) {
        favoriteViewModel.addToFavorites(crypto)
    }

    fun removeFromFavorites(crypto: Crypto) {
        favoriteViewModel.removeFromFavorites(crypto)
    }

    fun toggleFavorite(crypto: Crypto) {
        val isFavorite = favoriteViewModel.favorites.contains(crypto)
        val modifiedCrypto = crypto.copy(isFavorite = !isFavorite)

        if (isFavorite) {
            favoriteViewModel.removeFromFavorites(modifiedCrypto)
        } else {
            favoriteViewModel.addToFavorites(modifiedCrypto)
        }
    }
}
