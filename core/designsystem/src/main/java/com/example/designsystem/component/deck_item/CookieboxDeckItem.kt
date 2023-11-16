package com.example.designsystem.component.deck_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.icon.IcMinus
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxDeckItem(
    modifier: Modifier = Modifier,
    deckItemType: DeckItemType,
    imageUrl: String,
    count: Int,
    imageWidth: Dp,
    imageHeight: Dp,
    onMinusClick: () -> Unit,
) {
   Box(
       modifier = modifier
           .size(
               width = imageWidth,
               height = imageHeight,
           ),
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
                   .clickable(
                       interactionSource = remember { MutableInteractionSource() },
                       indication = null,
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
                           Color.Black,
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
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun CookieboxDeckItemPreview() {
    Row {
        CookieboxDeckItem(
            deckItemType = DeckItemType.BottomSheet,
            imageUrl = "",
            count = 1,
            imageWidth = 48.dp,
            imageHeight = 66.dp,
        ) {}

        Spacer(modifier = Modifier.width(10.dp))

        CookieboxDeckItem(
            deckItemType = DeckItemType.Detail,
            imageUrl = "",
            count = 2,
            imageWidth = 104.dp,
            imageHeight = 144.dp,
        ) {}
    }
}
