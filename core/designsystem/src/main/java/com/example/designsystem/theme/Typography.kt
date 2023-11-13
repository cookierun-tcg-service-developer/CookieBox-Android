package com.example.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.designsystem.R
import javax.annotation.concurrent.Immutable

private val cookierun = FontFamily(
    Font(R.font.cookierun_black, FontWeight.Black),
    Font(R.font.cookierun_bold, FontWeight.Bold),
    Font(R.font.cookierun_regular, FontWeight.Normal)
)

internal val Typography = CookieboxTypography(
    titleLargeBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        fontWeight = FontWeight.Black
    ),
    titleLargeB = TextStyle(
        fontFamily = cookierun,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        fontWeight = FontWeight.Bold
    ),
    titleLargeR = TextStyle(
        fontFamily = cookierun,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        fontWeight = FontWeight.Normal
    ),
    titleMediumBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 28.sp,
        lineHeight = 42.sp,
        fontWeight = FontWeight.Black
    ),
    titleMediumB = TextStyle(
        fontFamily = cookierun,
        fontSize = 28.sp,
        lineHeight = 42.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMediumR = TextStyle(
        fontFamily = cookierun,
        fontSize = 28.sp,
        lineHeight = 42.sp,
        fontWeight = FontWeight.Normal
    ),
    titleSmallBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Black
    ),
    titleSmallB = TextStyle(
        fontFamily = cookierun,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmallR = TextStyle(
        fontFamily = cookierun,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Normal
    ),
    textLargeBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Black
    ),
    textLargeB = TextStyle(
        fontFamily = cookierun,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Bold
    ),
    textLargeR = TextStyle(
        fontFamily = cookierun,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Normal
    ),
    textMediumBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Black
    ),
    textMediumB = TextStyle(
        fontFamily = cookierun,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Bold
    ),
    textMediumR = TextStyle(
        fontFamily = cookierun,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Normal
    ),
    textSmallBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Black
    ),
    textSmallB = TextStyle(
        fontFamily = cookierun,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Bold
    ),
    textSmallR = TextStyle(
        fontFamily = cookierun,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    ),
    captionBL = TextStyle(
        fontFamily = cookierun,
        fontSize = 11.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Black
    ),
    captionB = TextStyle(
        fontFamily = cookierun,
        fontSize = 11.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    captionR = TextStyle(
        fontFamily = cookierun,
        fontSize = 11.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal
    )
)

@Immutable
data class CookieboxTypography(
    val titleLargeBL: TextStyle,
    val titleLargeB: TextStyle,
    val titleLargeR: TextStyle,
    val titleMediumBL: TextStyle,
    val titleMediumB: TextStyle,
    val titleMediumR: TextStyle,
    val titleSmallBL: TextStyle,
    val titleSmallB: TextStyle,
    val titleSmallR: TextStyle,
    val textLargeBL: TextStyle,
    val textLargeB: TextStyle,
    val textLargeR: TextStyle,
    val textMediumBL: TextStyle,
    val textMediumB: TextStyle,
    val textMediumR: TextStyle,
    val textSmallBL: TextStyle,
    val textSmallB: TextStyle,
    val textSmallR: TextStyle,
    val captionBL: TextStyle,
    val captionB: TextStyle,
    val captionR: TextStyle,
)

val LocalTypography = staticCompositionLocalOf { Typography }
