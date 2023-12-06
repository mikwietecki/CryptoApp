package com.example.cryptoapp

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptoapp.network.Api
import com.example.cryptoapp.repository.CryptoRepo
import com.example.cryptoapp.repository.CryptoRepoImpl
import com.example.cryptoapp.screens.FavoriteViewModel
import com.example.cryptoapp.screens.FavoritesScreen
import com.example.cryptoapp.screens.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.coinmarketcap.com/data-api/v3/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(Api::class.java)
    }

    single {
        val api: Api = get()
        CryptoRepoImpl(api)
    } bind CryptoRepo::class

    viewModel { HomeViewModel() }
    viewModel { FavoriteViewModel() }
}