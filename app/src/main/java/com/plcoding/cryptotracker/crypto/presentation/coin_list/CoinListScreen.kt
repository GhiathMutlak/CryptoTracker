package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.CoinListItem
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.bitcoin
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreenRoot(
    modifier: Modifier = Modifier,
    state: CoinListState,
) {
    CoinListScreen(
        modifier = modifier,
        state = state
    )
}

@Composable
private fun CoinListScreen(
    modifier: Modifier = Modifier,
    state: CoinListState,
) {
    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { coin ->
                CoinListItem(
                    coinUi = coin,
                    onClick = { },
                    modifier = modifier.fillMaxWidth()
                )

                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun CoinListScreenPreview() {
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    bitcoin.copy(id = it.toString())
                }
            )
        )
    }
}