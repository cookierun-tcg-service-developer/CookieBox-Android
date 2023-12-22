package com.example.designsystem.component.deck_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.component.modifier.cookieboxClickable
import com.example.designsystem.icon.IcMinus
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxDeckItem(
    modifier: Modifier = Modifier,
    deckItemType: DeckItemType,
    imageUrl: String,
    count: Int,
    onMinusClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(deckItemSize(deckItemType)),
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "cookieImage",
        )

        if (deckItemType == DeckItemType.BottomSheet) {
            IcMinus(
                modifier = Modifier
                    .size(16.dp)
                    .background(
                        color = CookieboxTheme.color.cardMinus,
                        shape = RoundedCornerShape(
                            topEnd = 2.dp,
                            bottomStart = 6.dp,
                        )
                    )
                    .align(Alignment.TopEnd)
                    .cookieboxClickable(
                        onClick = onMinusClick,
                    ),
                tint = Color.White,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color(0xCC000000)
                        )
                    )
                )
                .padding(
                    vertical = if (deckItemType == DeckItemType.Detail) 10.dp
                    else 0.dp,
                )
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "x$count",
                style = CookieboxTheme.typography.textMediumR,
                color = Color.White,
            )
        }
    }
}

private fun deckItemSize(deckItemType: DeckItemType): DpSize {
    return when (deckItemType) {
        DeckItemType.BottomSheet -> DpSize(48.dp, 66.dp)
        DeckItemType.Detail -> DpSize(104.dp, 144.dp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun CookieboxDeckItemPreview() {
    Row {
        CookieboxDeckItem(
            deckItemType = DeckItemType.BottomSheet,
            imageUrl = "",
            count = 1,
        ) {}

        Spacer(modifier = Modifier.width(10.dp))

        CookieboxDeckItem(
            deckItemType = DeckItemType.Detail,
            imageUrl = "",
            count = 2,
        ) {}
    }
}
