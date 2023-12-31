package com.example.designsystem.component.card_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.R
import com.example.designsystem.component.modifier.cookieboxClickable
import com.example.designsystem.component.modifier.cookieboxCombinedClickable
import com.example.designsystem.icon.IcMinus
import com.example.designsystem.icon.IcPlus
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxCardItem(
    imageUrl: String,
    count: Int,
    onCardLongClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .size(width = 104.dp, height = 144.dp)
            .cookieboxCombinedClickable(
                onClick = {
                    if (count == 0) onPlusClick()
                },
                onLongClick = onCardLongClick
            ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = imageUrl,
                contentDescription = "cardImage",
                contentScale = ContentScale.Crop,
                colorFilter = if (count > 0) {
                    ColorFilter.tint(
                        color = CookieboxTheme.color.cardDarkFilter,
                        blendMode = BlendMode.Darken
                    )
                } else {
                    null
                },
            )

            if (count > 0) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IcPlus(
                        modifier = Modifier
                            .fillMaxWidth()
                            .cookieboxClickable(onClick = onPlusClick),
                        tint = Color.White
                    )
                    CookieboxCountBadge(
                        modifier = Modifier.padding(top = 11.dp, bottom = 5.dp),
                        count = count
                    )
                    IcMinus(
                        modifier = Modifier
                            .fillMaxWidth()
                            .cookieboxClickable(onClick = onMinusClick),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun CookieboxCountBadge(
    modifier: Modifier = Modifier,
    count: Int,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cookie),
            contentDescription = "cookie"
        )
        Text(
            modifier = Modifier.padding(bottom = 6.dp),
            text = "x$count",
            style = CookieboxTheme.typography.textLargeB,
            color = CookieboxTheme.color.brown80
        )
    }
}

@Preview
@Composable
private fun PreviewCookieboxCardItem() {
    var count by remember { mutableStateOf(0) }

    CookieboxCardItem(
        imageUrl = "",
        count = count,
        onCardLongClick = { },
        onPlusClick = { count += 1 },
        onMinusClick = { count -= 1 }
    )
}
