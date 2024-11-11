package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.greenBackground


@Composable
fun PriceChange(
    modifier: Modifier = Modifier,
    change: DisplayableNumber,
) {
    val contentColor = if (change.value > 0) {
        Color.Green
    } else {
        MaterialTheme.colorScheme.onErrorContainer
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(
                color = if (change.value > 0) {
                    greenBackground
                } else {
                    MaterialTheme.colorScheme.errorContainer
                }
            )
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (change.value > 0) {
                Icons.Default.KeyboardArrowUp
            } else {
                Icons.Default.KeyboardArrowDown
            },
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor
        )

        Text(
            text = "${change.formattedNumber}%",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = contentColor
        )
    }
}

@PreviewLightDark
@Composable
private fun PriceChangeNegativePreview() {
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayableNumber(-1.53, "-1.53")
        )
    }
}

@PreviewLightDark
@Composable
private fun PriceChangePositivePreview() {
    CryptoTrackerTheme {
        PriceChange(
            change = DisplayableNumber(3.6236, "3.62")
        )
    }
}