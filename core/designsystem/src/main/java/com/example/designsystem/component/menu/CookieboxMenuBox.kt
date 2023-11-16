package com.example.designsystem.component.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.icon.IcChevronDown
import com.example.designsystem.icon.IcChevronUp
import com.example.designsystem.theme.CookieboxTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CookieboxMenuBox(
    modifier: Modifier = Modifier,
    value: String,
    isInitialValue: Boolean = true,
    items: List<String>,
    menuMaxHeight: Dp = 264.dp,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    onItemClicked: (String) -> Unit,
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = onExpandedChange,
    ) {
        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = if (expanded || !isInitialValue) CookieboxTheme.color.grayscale80 else CookieboxTheme.color.grayscale5,
                textColor = if (expanded || !isInitialValue) Color.White else CookieboxTheme.color.grayscale40,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = CookieboxTheme.color.grayscale40
            ),
            shape = if (expanded) RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp) else RoundedCornerShape(8.dp),
            textStyle = CookieboxTheme.typography.textMediumR,
            trailingIcon = {
                val dynamicTint = if (expanded || !isInitialValue) Color.White else CookieboxTheme.color.grayscale40

                if (expanded) IcChevronDown(tint = Color.White) else IcChevronUp(tint = dynamicTint)
            }
        )
        CookieboxMenu(
            items = items,
            expanded = expanded,
            menuMaxHeight = menuMaxHeight,
            onDismissRequest = onDismissRequest,
            onItemClicked = onItemClicked,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewCookieboxMenu() {
    var startLevelExpanded by remember { mutableStateOf(false) }
    var endLevelExpanded by remember { mutableStateOf(false) }

    var startLevel by remember { mutableStateOf("시작 LV") }
    var endLevel by remember { mutableStateOf("끝 LV") }

    val startLevelOptions = listOf("시작 LV", "LV.1", "LV.2", "LV.3", "LV.4", "LV.5")
    val endLevelOptions = listOf("끝 LV", "LV.1", "LV.2", "LV.3", "LV.4", "LV.5")

    Row(
        modifier = Modifier.height(300.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CookieboxMenuBox(
            modifier = Modifier.weight(1f),
            value = startLevel,
            isInitialValue = startLevel == startLevelOptions.first(),
            items = startLevelOptions,
            expanded = startLevelExpanded,
            onExpandedChange = { startLevelExpanded = it },
            onDismissRequest = { startLevelExpanded = false },
            onItemClicked = { startLevel = it },
        )
        CookieboxMenuBox(
            modifier = Modifier.weight(1f),
            value = endLevel,
            isInitialValue = endLevel == endLevelOptions.first(),
            items = endLevelOptions,
            expanded = endLevelExpanded,
            onExpandedChange = { endLevelExpanded = it },
            onDismissRequest = { endLevelExpanded = false },
            onItemClicked = { endLevel = it },
        )
    }
}
