package com.example.cryptoapp.repository

import com.example.cryptoapp.models.ApiBaseModel
import com.example.cryptoapp.models.BaseModel
import com.example.cryptoapp.models.CryptoCurrencyList

interface CryptoRepo {
    suspend fun getListing():BaseModel<ApiBaseModel<CryptoCurrencyList>>
}