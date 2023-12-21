package com.example.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.button.ButtonType
import com.example.designsystem.component.button.CookieboxButton
import com.example.designsystem.component.deck_item.CookieboxDeckListItem
import com.example.designsystem.component.dialog.CookieBoxDeleteDialog
import com.example.designsystem.component.textfield.CookieboxTextField
import com.example.designsystem.icon.IcChevronLeft
import com.example.designsystem.icon.IcFilter
import com.example.designsystem.icon.IcSearch
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieDeckList() {
    var text by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "덱 리스트",
                style = CookieboxTheme.typography.titleMediumB,
                color = Color.Black,
            )
            if (isChecked) CookieboxButton(text = "선택 삭제", buttonType = ButtonType.Primary) { isShowDialog = true }
        }

        CookieboxTextField(
            value = text,
            hint = "덱 이름으로 검색",
            onValueChange = { text = it },
            trailingIcon = { IcSearch() }
        )

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "검색 결과",
                style = CookieboxTheme.typography.textMediumR,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "덱을 길게 눌러 선택하기",
                style = CookieboxTheme.typography.captionR,
                color = CookieboxTheme.color.grayscale40,
            )
            Spacer(modifier = Modifier.weight(1f))
            IcFilter(tint = CookieboxTheme.color.grayscale40)
        }

        val testList = mutableListOf(false, false, false, false, false, false, false)

        LazyVerticalGrid(
            modifier = Modifier.padding(bottom = 16.dp),
            columns = GridCells.Fixed(2),
        ) {
            items(testList.size) {
                CookieboxDeckListItem(
                    imageUrl = "",
                    deckName = "에클레어 컨트롤",
                    isChecked = testList[it],
                    onCardClick = {},
                    onCardLongClick = {
                        testList[it] = !testList[it]
                        isChecked = true
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun DeckListPreview() {
    CookieDeckList()
}
