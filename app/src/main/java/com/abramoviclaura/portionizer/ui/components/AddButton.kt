package com.abramoviclaura.portionizer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme

@Composable
fun AddButton(onClick: () -> Unit, modifier: Modifier = Modifier) =
    Icon(
        imageVector = Icons.Default.Add,
        contentDescription = stringResource(R.string.add),
        tint = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
            .clip(RoundedCornerShape(LocalDimensionSystem.current.cornerDimensions.medium))
            .clickable(onClick = onClick)
            .background(MaterialTheme.colorScheme.primary)
            .padding(LocalDimensionSystem.current.spacingDimensions.m)

    )

@Preview
@Composable
private fun PreviewAddButton() = PortionizerTheme {
    AddButton(onClick = {})
}
