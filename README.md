# CryptoApp
## Description

This project is a simple cryptocurrency tracking application implemented in Kotlin with the Android Jetpack Compose framework. It provides basic functionalities to browse a list of cryptocurrencies, add them to favorites, and view detailed information about them.

### Key Features:
  * Cryptocurrency Listing: Allows users to browse a list of cryptocurrencies.
  * Favorites Management: Enables users to add cryptocurrencies to favorites and remove them.
  * Search Functionality: Users can search for cryptocurrencies by name.
  * Data Fetching: Fetches cryptocurrency data from the CoinMarketCap API.
  * Modern UI: Utilizes Jetpack Compose for a modern and reactive user interface.
  #### Classes:
  * Crypto: Represents a cryptocurrency with various attributes like name, symbol, rank, price, and market cap.
  * Quote: Contains information about a cryptocurrency's price, volume, and percent change.
  * CryptoCurrencyList: Represents a list of cryptocurrencies.
  * Api: Retrofit interface for interacting with the CoinMarketCap API.
  * CryptoRepo: Interface for handling cryptocurrency data retrieval.
  * CryptoRepoImpl: Implementation of CryptoRepo responsible for fetching data from the API.
  * HomeViewModel: ViewModel responsible for managing data and business logic for the home screen.
  * FavoriteViewModel: ViewModel for managing favorite cryptocurrencies.
  * HomeScreen: Composable UI for the home screen, displaying various cryptocurrency lists.
  * FavoritesScreen: Composable UI for displaying favorite cryptocurrencies.
  * MainScreen: Main UI of the application with bottom navigation.
  * Settings: Composable UI for settings screen.

##
  * Technologies Used:
  * Kotlin: The core language used for development.
  * Android Jetpack Compose: Modern UI toolkit for building reactive UIs.
  * Retrofit: HTTP client for making API requests.
  * CoinMarketCap API: Used for fetching cryptocurrency data.
