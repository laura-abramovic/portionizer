package com.abramoviclaura.portionizer.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.appScreen() = this
    .fillMaxSize()
    .background(MaterialTheme.colorScheme.background)
    .systemBarsPadding()
