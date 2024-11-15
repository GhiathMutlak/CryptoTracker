package com.plcoding.cryptotracker.crypto.domain

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun fetchCoins(): Result<List<Coin>, NetworkError>
}