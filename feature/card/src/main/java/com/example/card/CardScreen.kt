package com.example.card

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.bottom_sheet.CookieboxDeckBottomSheet
import com.example.designsystem.component.button.CookieboxButton
import com.example.designsystem.component.card_item.CookieboxCardItem
import com.example.designsystem.component.dialog.CookieboxFilterDialog
import com.example.designsystem.component.dialog.DropdownItem
import com.example.designsystem.component.modifier.cookieboxClickable
import com.example.designsystem.component.textfield.CookieboxTextField
import com.example.designsystem.icon.IcFilter
import com.example.designsystem.icon.IcSearch
import com.example.designsystem.theme.CookieboxTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardScreen() {
    var text by remember { mutableStateOf("") }
    var deckName by remember { mutableStateOf("카드 리스트") }
    var showFilter by remember { mutableStateOf(false) }

    val cards = remember { List(20) { 0 }.toMutableStateList() }
    val values = remember { mutableStateListOf("시작 LV", "끝 LV", "시작 HP", "끝 HP") }
    val expandedStates = remember { mutableStateListOf(false, false, false, false) }
    val dropdownItems = values.mapIndexed { index, item ->
        DropdownItem(
            value = item,
            isExpanded = expandedStates[index],
            onDismissRequest = { expandedStates[index] = false },
            onExpandedChange = { expandedStates[index] = it },
            onItemClick = { values[index] = it },
        )
    }

    if (showFilter) {
        CookieboxFilterDialog(
            dropdownItems = dropdownItems,
            onDismissRequest = { showFilter = false },
            onResetClick = {},
            onApplyClick = {},
            onColorFilterClick = {},
            onTypeFilterClick = {},
            onFlipFilterClick = {},
        )
    }

    val scaffoldState = rememberBottomSheetScaffoldState()

    LaunchedEffect(cards.sum()) {
        if (cards.sum() > 0) {
            scaffoldState.bottomSheetState.expand()
        } else {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    CookieboxDeckBottomSheet(
        count = cards.sum(),
        imageUrl = "",
        scaffoldState = scaffoldState,
        onMinusClick = {},
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 28.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                modifier = Modifier.cookieboxClickable { /* TODO: Navigate to deck list */ },
                text = "덱 리스트 >",
                style = CookieboxTheme.typography.textMediumR,
                color = CookieboxTheme.color.chipBlue,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                BasicTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 6.dp),
                    value = deckName,
                    singleLine = true,
                    maxLines = 1,
                    onValueChange = { deckName = it },
                    textStyle = CookieboxTheme.typography.titleMediumB,
                )
                if (deckName != "카드 리스트") {
                    CookieboxButton(
                        text = "저장",
                        enabled = cards.sum() >= 60,
                        onClick = { /* TODO: Save deck */ },
                    )
                }
            }
            CookieboxTextField(
                modifier = Modifier.padding(vertical = 16.dp),
                value = text,
                hint = "카드 이름으로 검색",
                onValueChange = { text = it },
                trailingIcon = { IcSearch(tint = CookieboxTheme.color.grayscale40) },
            )
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "검색 결과",
                    style = CookieboxTheme.typography.textMediumR,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "카드를 길게 눌러 자세히 보기",
                    style = CookieboxTheme.typography.captionR,
                    color = CookieboxTheme.color.grayscale40,
                )
                Spacer(modifier = Modifier.weight(1f))
                IcFilter(
                    modifier = Modifier.cookieboxClickable { showFilter = true },
                    tint = CookieboxTheme.color.grayscale40,
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(
                    bottom = if (scaffoldState.bottomSheetState.isExpanded) 116.dp else 0.dp
                ),
            ) {
                items(20) {
                    CookieboxCardItem(
                        imageUrl = "",
                        count = cards[it],
                        onCardLongClick = { /*TODO: Show card dialog */ },
                        onPlusClick = { cards[it] += 1 },
                        onMinusClick = { cards[it] -= 1 },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun CardScreenPreview() {
    CardScreen()
}
