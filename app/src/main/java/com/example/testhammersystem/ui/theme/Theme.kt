package com.example.testhammersystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    surface = MainSurface,
    background = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightColorPalette = lightColors(
    surface = MainSurface,
    background = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun TestHammerSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}