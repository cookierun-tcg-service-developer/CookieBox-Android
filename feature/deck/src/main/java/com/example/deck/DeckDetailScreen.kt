package com.example.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.button.ButtonType
import com.example.designsystem.component.button.CookieboxButton
import com.example.designsystem.component.deck_item.CookieboxDeckItem
import com.example.designsystem.component.deck_item.DeckItemType
import com.example.designsystem.component.dialog.CookieBoxDeleteDialog
import com.example.designsystem.icon.IcChevronLeft
import com.example.designsystem.icon.IcLink
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun DeckDetailScreen() {
    var isShowDialog by remember { mutableStateOf(false) }

    if (isShowDialog) {
        CookieBoxDeleteDialog(
            onDismissRequest = { isShowDialog = false },
            onCardDelete = { isShowDialog = false },
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "아클레어 컨트롤",
                    style = CookieboxTheme.typography.textSmallR,
                    color = CookieboxTheme.color.red50,
                )
                Text(
                    text = "을 삭제하면 되돌릴 수 없어요",
                    style = CookieboxTheme.typography.textSmallR,
                    color = CookieboxTheme.color.grayscale40,
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp, start = 16.dp, end = 16.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IcChevronLeft(
                modifier = Modifier.size(20.dp),
                tint = CookieboxTheme.color.chipBlue
            )
            Text(
                text = " 돌아가기",
                style = CookieboxTheme.typography.textMediumR,
                color = CookieboxTheme.color.chipBlue,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "에클레어 컨트롤",
                style = CookieboxTheme.typography.titleMediumB,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.weight(1f))
            IcLink(
                modifier = Modifier.size(20.dp),
                tint = CookieboxTheme.color.chipBlue
            )
            Text(
                text = "공유",
                style = CookieboxTheme.typography.textSmallR,
                color = CookieboxTheme.color.chipBlue,
            )
        }

        Box {
            LazyVerticalGrid(
                modifier = Modifier.padding(bottom = 16.dp),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(20) {
                    CookieboxDeckItem(
                        modifier = Modifier.padding(bottom = if (it == 19) 88.dp else 0.dp),
                        deckItemType = DeckItemType.Detail,
                        imageUrl = "",
                        count = it + 1,
                    ) {}
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.White,
                            )
                        )
                    )
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CookieboxButton(
                    modifier = Modifier
                        .weight(0.5f)
                        .height(50.dp),
                    text = "덱 수정",
                    buttonType = ButtonType.Primary
                ) { }
                CookieboxButton(
                    modifier = Modifier
                        .weight(0.5f)
                        .height(50.dp),
                    text = "덱 삭제",
                    buttonType = ButtonType.Primary
                ) { isShowDialog = true }
            }
        }
    }
}

@Preview
@Composable
fun DeckDetailScreenPreview() {
    DeckDetailScreen()
}
