package com.example.designsystem.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxSegmentedButton(
    items: List<String>,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 11.dp),
) {
    val checkedList = remember { mutableStateListOf<Int>() }

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items.forEachIndexed { index, item ->
            val backgroundColor = backgroundColor(item = item)

            CookieboxButton(
                text = item,
                useTextGradient = false,
                buttonColors = ButtonDefaults.buttonColors(
                    backgroundColor = if (index in checkedList) backgroundColor else CookieboxTheme.color.grayscale5,
                    contentColor = if (index in checkedList) Color.White else CookieboxTheme.color.grayscale40
                ),
                contentPadding = contentPadding
            ) {
                if (index in checkedList) checkedList.remove(index) else checkedList.add(index)
            }
        }
    }
}

@Composable
fun backgroundColor(item: String): Color {
    return when (item) {
        "레드" -> CookieboxTheme.color.red50
        "옐로" -> CookieboxTheme.color.yellow50
        "그린" -> CookieboxTheme.color.green60
        else -> CookieboxTheme.color.grayscale80
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewCookieboxSegmentedButton() {
    Column {
        CookieboxSegmentedButton(items = listOf("쿠키", "트랩", "아이템", "스테이지"))
        CookieboxSegmentedButton(
            items = listOf("레드", "옐로", "그린"),
            contentPadding = PaddingValues(horizontal = 37.5.dp, vertical = 11.dp)
        )
    }
}
