package com.abramoviclaura.portionizer.ui.screens.ingredientslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.ui.components.AddButton
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme

@Composable
fun IngredientListEmptyContent(
    onAddButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    AddButton(onClick = onAddButtonClick)

    Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.m))

    Text(
        text = stringResource(R.string.add_ingredient),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview
@Composable
private fun PreviewIngredientListEmptyContent() = PortionizerTheme {
    IngredientListEmptyContent(onAddButtonClick = {})
}
