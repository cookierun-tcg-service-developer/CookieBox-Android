package com.example.designsystem.component.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.deck_item.CookieboxDeckItem
import com.example.designsystem.component.deck_item.DeckItemType
import com.example.designsystem.theme.CookieboxTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CookieboxDeckBottomSheet(
    modifier: Modifier = Modifier,
    count: Int,
    imageUrl: String,
    scaffoldState: BottomSheetScaffoldState,
    onMinusClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetContent = {
            CookieboxDeckBottomSheetContent(
                imageUrl = imageUrl,
                count = count,
                onMinusClick = onMinusClick,
            )
        },
        sheetPeekHeight = 0.dp,
    ) {
        content()
    }
}

@Composable
fun CookieboxDeckBottomSheetContent(
    modifier: Modifier = Modifier,
    deckItemType: DeckItemType = DeckItemType.BottomSheet,
    imageUrl: String,
    count: Int,
    onMinusClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                ),
            )
            .padding(
                top = 8.dp,
                bottom = 16.dp,
            ),
        horizontalAlignment = Alignment.End,
    ) {
        Text(
            modifier = Modifier.padding(
                end = 16.dp,
            ),
            text = buildAnnotatedString {
                append("5") // 추 후 list의 size로 수정 예정
                withStyle(style = SpanStyle(color = CookieboxTheme.color.deckBottomSheet)) {
                    append("/60장")
                }
            },
            style = CookieboxTheme.typography.captionR
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(15) {
                CookieboxDeckItem(
                    deckItemType = deckItemType,
                    imageUrl = imageUrl,
                    count = count,
                    onMinusClick = onMinusClick
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun CookieboxDeckBottomSheetPreview() {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val scope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize()) {
        CookieboxDeckBottomSheet(
            imageUrl = "",
            count = 4,
            scaffoldState = scaffoldState,
            onMinusClick = {}
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }) {
                    Text("Main Screen Content")
                }
            }
        }
    }
}

@Preview
@Composable
private fun CookieboxDeckBottomSheetContentPreview() {
    CookieboxDeckBottomSheetContent(
        imageUrl = "",
        count = 4,
    ) {}
}
