package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes

data class CoinUi(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: DisplayableNumber,
    val marketCapUsd: DisplayableNumber,
    val priceChange23h: DisplayableNumber,
    @DrawableRes val iconRes: Int,
)

data class DisplayableNumber(
    val value: Double,
    val formattedNumber: String,
)