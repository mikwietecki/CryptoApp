package com.example.cryptoapp.repository

import com.example.cryptoapp.models.ApiBaseModel
import com.example.cryptoapp.models.BaseModel
import com.example.cryptoapp.models.CryptoCurrencyList
import com.example.cryptoapp.network.Api
import java.lang.Exception

class CryptoRepoImpl(private val api: Api): CryptoRepo {
    override suspend fun getListing(): BaseModel<ApiBaseModel<CryptoCurrencyList>> {
        try {
            api.getListing(
                start = 1,
                limit = 100,
            ).also {
                if (it.isSuccessful) {
                    return BaseModel.Success(data = it.body()!!)
                } else {
                    return BaseModel.Error("Błąd")
                }
            }
        } catch (e:Exception) {
            return BaseModel.Error(e.message.toString())
        }
    }
}