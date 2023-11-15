package com.example.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import javax.annotation.concurrent.Immutable

internal val Colors = CookieboxColor(
    red50 = Red50,
    red70 = Red70,
    yellow50 = Yellow50,
    yellowGradientStart = YellowGradientStart,
    yellowGradientEnd = YellowGradientEnd,
    green60 = Green60,
    grayscale5 = Grayscale5,
    grayscale10 = Grayscale10,
    grayscale20 = Grayscale20,
    grayscale30 = Grayscale30,
    grayscale40 = Grayscale40,
    grayscale70 = Grayscale70,
    brown80 = Brown80,
    brown90 = Brown90,
    orange40 = Orange40,
    cardTypeChip = CardTypeChip,
    cardBackground = CardBackground,
    textSecondary = TextSecondary,
    dividerBackground = DividerBackground
)

@Immutable
data class CookieboxColor(
    val red50: Color,
    val red70: Color,
    val yellow50: Color,
    val yellowGradientStart: Color,
    val yellowGradientEnd: Color,
    val green60: Color,
    val grayscale5: Color,
    val grayscale10: Color,
    val grayscale20: Color,
    val grayscale30: Color,
    val grayscale40: Color,
    val grayscale70: Color,
    val brown80: Color,
    val brown90: Color,
    val orange40: Color,
    val cardTypeChip: Color,
    val cardBackground: Color,
    val textSecondary: Color,
    val dividerBackground: Color
)

val LocalColor = staticCompositionLocalOf { Colors }

@Composable
fun CookieboxTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColor provides Colors,
        LocalTypography provides Typography,
        content = content
    )
}

object CookieboxTheme {
    val color: CookieboxColor
        @Composable
        get() = LocalColor.current

    val typography: CookieboxTypography
        @Composable
        get() = LocalTypography.current
}
