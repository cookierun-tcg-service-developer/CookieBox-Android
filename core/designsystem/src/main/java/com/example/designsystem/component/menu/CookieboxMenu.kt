package com.example.designsystem.component.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.CookieboxTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun ExposedDropdownMenuBoxScope.CookieboxMenu(
    items: List<String>,
    menuMaxHeight: Dp,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onItemClicked: (String) -> Unit,
) {
    MaterialTheme(
        shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
    ) {
        ExposedDropdownMenu(
            modifier = Modifier
                .background(
                    color = CookieboxTheme.color.grayscale80,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                )
                .heightIn(max = menuMaxHeight),
            expanded = expanded,
            onDismissRequest = onDismissRequest,
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onDismissRequest()
                        onItemClicked(item)
                    },
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 11.dp),
                ) {
                    Text(
                        text = item,
                        style = CookieboxTheme.typography.textMediumR,
                        color = Color.White,
                    )
                }
            }
        }
        if (expanded) Divider(color = CookieboxTheme.color.grayscale40, thickness = 2.dp)
    }
}
