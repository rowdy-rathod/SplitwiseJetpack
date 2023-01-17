package com.tujhe_majhe.splitwisejetpack.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

//private val DarkColorPalette = darkColors(
//    primary = darkPrimary500,
//    primaryVariant = darkPrimaryVariant700,
//    secondary = darkSecondary200,
//    background = darkBackground,
//    surface = darkSurface
//)
//
//private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200
//
//    /* Other default colors to override
//    background = Color.White,
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//    */
//)
private val DarkColorPalette = darkColors(
    primary = ThemeColors.Night.primary,
    onPrimary = ThemeColors.Night.text,
    surface = ThemeColors.Night.surfaceColor,
    background = ThemeColors.Night.backgroundColor
)

private val LightColorPalette = lightColors(
    primary = ThemeColors.Day.primary,
    onPrimary = ThemeColors.Day.text,
    surface = ThemeColors.Day.surfaceColor,
    background = ThemeColors.Day.backgroundColor
)

private val DarkStatusBar = ThemeColors.Night.backgroundColor
private val LightStatusBar = ThemeColors.Day.backgroundColor

@Composable
fun SplitwiseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        changeStatusBarColor(DarkStatusBar)
        DarkColorPalette
    } else {
        changeStatusBarColor(LightStatusBar)
        LightColorPalette
    }



    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun changeStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = color
    )
}





@Composable
fun DarkTextFieldColor() = TextFieldDefaults.textFieldColors(
    textColor = Color.Gray,
    disabledTextColor = Color.Black,
    backgroundColor = Color.Transparent,
    focusedIndicatorColor = Color.White,
    unfocusedIndicatorColor = Color.White,
    disabledIndicatorColor = Color.Black
)

@Composable
fun LightTextFieldColor()= TextFieldDefaults.textFieldColors(

    textColor = Color.Black,
    disabledTextColor = Color.Black,
    backgroundColor = Color.Transparent,
    focusedIndicatorColor = Color.Black,
    unfocusedIndicatorColor = Color.Black,
    disabledIndicatorColor = Color.Black
)
