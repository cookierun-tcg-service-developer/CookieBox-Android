package com.example.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.CookieboxTheme

@OptIn(ExperimentalTextApi::class)
@Composable
fun CookieboxButton(
    text: String,
    buttonType: ButtonType = ButtonType.Primary,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(8.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    onClick: () -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val borderColor = if (isPressed) Color.Black else CookieboxTheme.color.grayscale40
    val gradientColors = listOf(CookieboxTheme.color.yellowGradientStart, CookieboxTheme.color.yellowGradientEnd)
    val gradientBrush = Brush.verticalGradient(gradientColors)

    Button(
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        border = if (buttonType == ButtonType.Secondary) BorderStroke(
            width = 2.dp,
            color = if (enabled) borderColor else borderColor.copy(alpha = 0.5f)
        ) else null,
        colors = buttonColors(buttonType = buttonType, isPressed = isPressed),
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = CookieboxTheme.typography.textMediumR.copy(
                brush = if (buttonType == ButtonType.Primary && enabled) gradientBrush else null
            )
        )
    }
}

@Composable
fun buttonColors(buttonType: ButtonType, isPressed: Boolean): ButtonColors {
    return when (buttonType) {
        ButtonType.Primary -> ButtonDefaults.buttonColors(
            backgroundColor = if (isPressed) CookieboxTheme.color.brown90 else CookieboxTheme.color.brown80,
            disabledBackgroundColor = CookieboxTheme.color.grayscale10,
            disabledContentColor = CookieboxTheme.color.grayscale40
        )

        ButtonType.Secondary -> ButtonDefaults.buttonColors(
            backgroundColor = if (isPressed) CookieboxTheme.color.grayscale30 else Color.White,
            contentColor = if (isPressed) Color.Black else CookieboxTheme.color.grayscale40,
            disabledBackgroundColor = Color.White,
            disabledContentColor = CookieboxTheme.color.grayscale40.copy(alpha = 0.5f)
        )

        ButtonType.Negative -> ButtonDefaults.buttonColors(
            backgroundColor = if (isPressed) CookieboxTheme.color.red70 else CookieboxTheme.color.red50,
            contentColor = if (isPressed) CookieboxTheme.color.grayscale40 else Color.White,
            disabledBackgroundColor = CookieboxTheme.color.red50.copy(alpha = 0.5f),
            disabledContentColor = Color.White
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewCookieboxButton() {
    Row {
        Column {
            CookieboxButton(text = "Button", buttonType = ButtonType.Primary) { }
            CookieboxButton(text = "Button", buttonType = ButtonType.Primary, enabled = false) { }
        }
        Column {
            CookieboxButton(text = "Button", buttonType = ButtonType.Secondary) { }
            CookieboxButton(text = "Button", buttonType = ButtonType.Secondary, enabled = false) { }
        }
        Column {
            CookieboxButton(text = "Button", buttonType = ButtonType.Negative) { }
            CookieboxButton(text = "Button", buttonType = ButtonType.Negative, enabled = false) { }
        }
    }
}
