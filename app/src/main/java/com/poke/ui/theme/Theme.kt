package com.poke.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PokeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        MaterialTheme.colorScheme.copy(
            primary = Purple200,
            //primaryVariant = Purple700,
            secondary = Teal200
        )
    } else {
        MaterialTheme.colorScheme.copy(
            primary = Purple500,
            //primaryVariant = Purple700,
            secondary = Teal200
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
