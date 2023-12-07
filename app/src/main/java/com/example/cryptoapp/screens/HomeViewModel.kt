package com.example.cryptoapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.models.ApiBaseModel
import com.example.cryptoapp.models.BaseModel
import com.example.cryptoapp.models.Crypto
import com.example.cryptoapp.models.CryptoCurrencyList
import com.example.cryptoapp.repository.CryptoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.Locale

class HomeViewModel : ViewModel(), KoinComponent {
    private val repo: CryptoRepo by inject()

    private val _response: MutableStateFlow<BaseModel<ApiBaseModel<CryptoCurrencyList>>?> =
        MutableStateFlow(null)
    val response = _response.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun filterCryptoList(cryptoList: List<Crypto>): List<Crypto> {
        val query = searchQuery.value.trim().toLowerCase(Locale.getDefault())
        return if (query.isEmpty()) {
            cryptoList
        } else {
            cryptoList.filter {
                it.name.toLowerCase(Locale.getDefault()).contains(query)
            }
        }
    }

    fun getListing() {
        viewModelScope.launch {
            _response.update { BaseModel.Loading }
            repo.getListing().also { res ->
                _response.update { res }
            }
        }
    }
}
