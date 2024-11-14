package com.plcoding.cryptotracker.crypto.domain

import android.icu.text.NumberFormat
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUi
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import java.util.Locale

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: Double,
    val marketCapUsd: Double,
    val priceChange23h: Double,
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceChange23h = priceChange23h.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formattedNumber = formatter.format(this)
    )
}