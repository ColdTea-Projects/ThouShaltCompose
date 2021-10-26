package de.sample.naci.composetutorial.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val materialBlue100 = Color(0xFF00BCD4)
val materialBlue200 = Color(0xFF03A9F4)
val materialBlue300 = Color(0xFF2196F3)
val materialBlue400 = Color(0xFF3F51B5)
val materialPurple100 = Color(0xFF673AB7)
val materialPurple200 = Color(0xFF9C27B0)
val materialPurple300 = Color(0xFFBB86FC)
val materialWhite = Color(0xFFEEE8F7)
val materialBlack = Color(0xFF100029)


val LightColors = lightColors(
    primary = materialBlue100,
    primaryVariant = materialBlue200,
    secondary = materialPurple100,
    secondaryVariant = materialPurple300,
    background = materialWhite,
    surface = materialWhite,
    error = materialPurple200
)

val DarkColors = darkColors(
    primary = materialBlue300,
    primaryVariant = materialBlue400,
    secondary = materialPurple100,
    secondaryVariant = materialPurple300,
    background = materialBlack,
    surface = materialWhite,
    error = materialPurple200
)