package com.example.splitwisejetpack.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val darkPrimary500 = Color(0x86E00EE)
val darkPrimaryVariant700 = Color(0X88370083)
val darkSecondary200 = Color(0x8803DAC5)
val darkSecondary500 = Color(0x88018786)
val darkBackground = Color(0x88000000)
val darkSurface = Color(0x88FFFFFF)

@Composable
fun Colors.colorSurfaceVariant() =
    colorForTheme(light = Color(0X80000000), dark = Color(0x8FFFFFFF))


@Composable
fun colorForTheme(light: Color, dark: Color) = if (isSystemInDarkTheme()) dark else light



sealed class ThemeColors(
    val backgroundColor:Color,
    val surfaceColor:Color,
    val primary: Color,
    val text:Color
){
    object Night: ThemeColors(
        backgroundColor = Color(0xFF000000),
        surfaceColor = Color(0xFF000000),
        primary=Color(0xFFFFFFFF),
        text = Color(0xFF000000)
    )
    object Day: ThemeColors(
        backgroundColor = Color(0xFFFFFFFF),
        surfaceColor = Color(0xFFFFFFFF),
        primary=Color(0xFF3F51B5),
        text = Color(0xFFFFFFFF)
    )
}


