package com.example.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxChip(
    cardColor: CardColor,
) {
    Box(
        modifier = Modifier
            .background(
                color = chipBackgroundColor(cardColor = cardColor),
                shape = RoundedCornerShape(13.dp)
            )
            .padding(horizontal = 13.5.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cardColor.text,
            style = CookieboxTheme.typography.captionR,
            color = Color.Black,
        )
    }
}

@Composable
fun CookieboxChip(
    cardType: CardType,
) {
    Box(
        modifier = Modifier
            .background(
                color = CookieboxTheme.color.cardTypeChip,
                shape = RoundedCornerShape(13.dp)
            )
            .padding(horizontal = 15.5.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cardType.text,
            style = CookieboxTheme.typography.captionR,
            color = Color.White,
        )
    }
}

@Composable
private fun chipBackgroundColor(cardColor: CardColor): Color {
    return when (cardColor) {
        CardColor.Red -> CookieboxTheme.color.red50
        CardColor.Yellow -> CookieboxTheme.color.yellow50
        CardColor.Green -> CookieboxTheme.color.green60
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewCookieboxChip() {
    Row {
        Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
            CookieboxChip(cardColor = CardColor.Red)
            CookieboxChip(cardColor = CardColor.Yellow)
            CookieboxChip(cardColor = CardColor.Green)
        }
        Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
            CookieboxChip(cardType = CardType.Cookie)
            CookieboxChip(cardType = CardType.Trap)
            CookieboxChip(cardType = CardType.Item)
            CookieboxChip(cardType = CardType.Stage)
        }
    }
}
