package com.example.testhammersystem.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testhammersystem.R

private val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.SemiBold),
)
private val SfUiDisplay = FontFamily(
    Font(R.font.sf_ui_display, FontWeight.Normal),
)

val Typography = Typography(
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 18.75.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),
    subtitle2 = TextStyle(
        fontFamily = SfUiDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.71.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),
    button = TextStyle(
        fontFamily = SfUiDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 15.51.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    caption = TextStyle(
        fontFamily = SfUiDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
)