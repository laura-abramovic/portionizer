package com.abramoviclaura.portionizer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun PortionizerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val dimensionSystem = DimensionSystem(
        spacingDimensions = spacingDimensionValues
    )

    CompositionLocalProvider(
        LocalDimensionSystem provides dimensionSystem,
        content = content
    )
}

object PortionizerTheme {
    val dimensionSystem: DimensionSystem
        @Composable
        get() = LocalDimensionSystem.current
}
