package com.abramoviclaura.portionizer.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val spacingDimensionValues = SpacingDimensions(
    xxs = 2.dp,
    xs = 4.dp,
    s = 8.dp,
    m = 16.dp,
    l = 32.dp,
    xl = 64.dp,
    xxl = 128.dp
)

@Immutable
data class SpacingDimensions(
    val xxs: Dp = Dp.Unspecified,
    val xs: Dp = Dp.Unspecified,
    val s: Dp = Dp.Unspecified,
    val m: Dp = Dp.Unspecified,
    val l: Dp = Dp.Unspecified,
    val xl: Dp = Dp.Unspecified,
    val xxl: Dp = Dp.Unspecified,
)

@Immutable
data class DimensionSystem(
    val spacingDimensions: SpacingDimensions = SpacingDimensions(),
)

val LocalDimensionSystem = staticCompositionLocalOf { DimensionSystem() }
