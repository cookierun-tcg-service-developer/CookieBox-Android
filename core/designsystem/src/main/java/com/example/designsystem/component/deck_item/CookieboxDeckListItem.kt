package com.example.designsystem.component.deck_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.component.modifier.cookieboxCombinedClickable
import com.example.designsystem.icon.IcCheckMark
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxDeckListItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    deckName: String,
    isChecked: Boolean,
    onCardClick: () -> Unit,
    onCardLongClick: () -> Unit,
) {
    Column(
        modifier = modifier.background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(modifier = Modifier.size(160.dp, 220.dp)) {
            AsyncImage(
                modifier = Modifier
                    .cookieboxCombinedClickable(
                        onClick = onCardClick,
                        onLongClick = onCardLongClick,
                    ),
                model = imageUrl,
                contentDescription = "cookieImage",
                colorFilter = if (isChecked) {
                    ColorFilter.tint(
                        color = CookieboxTheme.color.cardDarkFilter,
                        blendMode = BlendMode.Darken
                    )
                } else null
            )
            if (isChecked) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IcCheckMark(tint = Color.Black)
                }
            }
        }
        Text(
            text = deckName,
            style = CookieboxTheme.typography.textMediumR,
            color = Color.Black,
        )
    }
}

@Preview
@Composable
fun CookieboxDeckListItemPreview() {
    var isChecked by remember { mutableStateOf(false) }

    CookieboxDeckListItem(
        imageUrl = "",
        deckName = "에클레어 컨트롤",
        isChecked = isChecked,
        onCardClick = {},
        onCardLongClick = { isChecked = !isChecked }
    )
}