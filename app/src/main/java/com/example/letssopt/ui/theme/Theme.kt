package com.example.letssopt.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = darkColorScheme(
    primary = Red,
    background = Background,
    surface = Surface,
    onPrimary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun LETSSOPTTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}