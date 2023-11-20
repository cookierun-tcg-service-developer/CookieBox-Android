package com.example.designsystem.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.designsystem.component.button.ButtonType
import com.example.designsystem.component.button.CookieboxButton
import com.example.designsystem.component.button.CookieboxSegmentedButton
import com.example.designsystem.component.menu.CookieboxMenuBox
import com.example.designsystem.icon.IcCross
import com.example.designsystem.theme.CookieboxTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CookieboxFilterDialog(
    dropdownItems: List<DropdownItem>,
    onDismissRequest: () -> Unit,
    onResetClick: () -> Unit,
    onApplyClick: () -> Unit,
    onColorFilterClick: (String) -> Unit,
    onTypeFilterClick: (String) -> Unit,
    onFlipFilterClick: (String) -> Unit,
) {
    val cardColors = listOf("레드", "옐로", "그린")
    val cardTypes = listOf("쿠키", "트랩", "아이템", "스테이지")
    val flipEffects = listOf("플립 효과 있음", "플립 효과 없음")
    val menuItems = listOf(
        "시작 LV," + generateOptions("LV"),
        "끝 LV," + generateOptions("LV"),
        "시작 HP," + generateOptions("HP"),
        "끝 HP," + generateOptions("HP")
    )

    FullScreenDialog(onDismissRequest = onDismissRequest) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "필터",
                style = CookieboxTheme.typography.titleSmallB,
                color = Color.Black
            )
            IcCross(
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onDismissRequest
                )
            )
        }

        CookieboxFilterItem(text = "카드 색상") {
            CookieboxSegmentedButton(
                items = cardColors,
                onItemClick = onColorFilterClick
            )
        }

        CookieboxFilterItem(text = "카드 유형") {
            CookieboxSegmentedButton(
                items = cardTypes,
                onItemClick = onTypeFilterClick
            )
        }

        CookieboxFilterItem(text = "플립 효과 유무") {
            CookieboxSegmentedButton(
                items = flipEffects,
                onItemClick = onFlipFilterClick
            )
        }

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = 2
        ) {
            repeat(4) {
                val menu = dropdownItems[it]

                Column(
                    modifier = Modifier
                        .width(0.dp) // FIXME: width를 설정해야 weight가 정상적으로 작동함
                        .weight(1f)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 24.dp),
                        text = when (it) {
                            0 -> "카드 LV"
                            2 -> "카드 HP"
                            else -> ""
                        },
                        style = CookieboxTheme.typography.textLargeB,
                        color = Color.Black
                    )
                    val options = menuItems[it].split(",")
                    CookieboxMenuBox(
                        modifier = Modifier.padding(top = 10.dp),
                        value = menu.value,
                        expanded = menu.isExpanded,
                        items = options,
                        isInitialValue = menu.value == options.first(),
                        onDismissRequest = menu.onDismissRequest,
                        onExpandedChange = menu.onExpandedChange,
                        onItemClicked = menu.onItemClick
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp, bottom = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CookieboxButton(
                modifier = Modifier.weight(1f),
                text = "초기화",
                buttonType = ButtonType.Secondary,
                contentPadding = PaddingValues(vertical = 13.dp),
                onClick = onResetClick
            )
            CookieboxButton(
                modifier = Modifier.weight(1f),
                text = "적용하기",
                buttonType = ButtonType.Primary,
                contentPadding = PaddingValues(vertical = 13.dp),
                onClick = onApplyClick
            )
        }
    }
}

@Composable
fun FullScreenDialog(
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(16.dp),
            content = content
        )
    }
}

@Composable
fun CookieboxFilterItem(
    text: String,
    content: @Composable RowScope.() -> Unit,
) {
    Text(
        modifier = Modifier.padding(top = 24.dp),
        text = text,
        style = CookieboxTheme.typography.textLargeB,
        color = Color.Black
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}

data class DropdownItem(
    val value: String,
    val isExpanded: Boolean,
    val onDismissRequest: () -> Unit,
    val onExpandedChange: (Boolean) -> Unit,
    val onItemClick: (String) -> Unit,
)

private fun generateOptions(prefix: String): String {
    return (1..10).joinToString(",") { "$prefix.$it" }
}

@Preview
@Composable
private fun PreviewCookieboxFilterDialog() {
    val values = remember { mutableStateListOf("시작 LV", "끝 LV", "시작 HP", "끝 HP") }
    val expandedStates = remember { mutableStateListOf(false, false, false, false) }

    val dropdownItems = values.mapIndexed { index, item ->
        DropdownItem(
            value = item,
            isExpanded = expandedStates[index],
            onDismissRequest = { expandedStates[index] = false },
            onExpandedChange = { expandedStates[index] = it },
            onItemClick = { values[index] = it }
        )
    }

    CookieboxFilterDialog(
        dropdownItems = dropdownItems,
        onDismissRequest = { },
        onResetClick = { },
        onApplyClick = { },
        onColorFilterClick = { },
        onFlipFilterClick = { },
        onTypeFilterClick = { },
    )
}

