package com.example.designsystem.component.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.CookieboxTheme

@Composable
fun CookieboxSnackbar(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp),
            )
            .padding(horizontal = 25.dp, vertical = 5.dp),
        text = text,
        style = CookieboxTheme.typography.textSmallR,
        color = Color.Black,
    )
}

@Preview
@Composable
fun CookieboxSnackbarPreview() {
    CookieboxSnackbar(
        text = "카드의 효과를 복사했습니다.",
    )
}