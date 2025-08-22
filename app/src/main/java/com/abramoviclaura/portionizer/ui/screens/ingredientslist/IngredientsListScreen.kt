package com.abramoviclaura.portionizer.ui.screens.ingredientslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.ui.components.AddButton
import com.abramoviclaura.portionizer.ui.components.IngredientListItem
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme
import com.abramoviclaura.portionizer.ui.utils.appScreen
import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState

@Composable
fun IngredientsListScreen(
    ingredients: List<IngredientViewState>,
) {

    Column(
        modifier = Modifier
            .appScreen()
            .padding(LocalDimensionSystem.current.spacingDimensions.m)
    ) {
        Text(
            text = stringResource(R.string.ingredients),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.xl))

        if (ingredients.isEmpty()) {
            IngredientListEmptyContent({})
        } else {
            IngredientsListContent(
                ingredients = ingredients,
                onAddButtonClick = {},
                onSplitPortionsButtonClick = {}
            )
        }
    }
}

@Composable
private fun IngredientsListContent(
    ingredients: List<IngredientViewState>,
    onAddButtonClick: () -> Unit,
    onSplitPortionsButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(ingredients) { ingredient ->
                IngredientListItem(
                    name = ingredient.name,
                    quantity = ingredient.quantity.toString(),
                    onEditClick = {},
                    onDeleteClick = {}
                )
            }
        }

        Spacer(Modifier.weight(1f))

        AddButton(
            onClick = onAddButtonClick,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(Modifier.height(LocalDimensionSystem.current.spacingDimensions.l))

        Button(
            onClick = onSplitPortionsButtonClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.split_portions).uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun PreviewIngredientsListScreen() = PortionizerTheme {
    val ingredients = listOf(
        IngredientViewState("Carrot", 360),
        IngredientViewState("Red bell peper", 120),
        IngredientViewState("Olive oil", 6),
        IngredientViewState("Onion", 84),
        IngredientViewState("Rice", 80),
        IngredientViewState("Chicken", 500),
    )

    IngredientsListScreen(ingredients)
}

@Preview
@Composable
private fun PreviewIngredientsListEmptyScreen() = PortionizerTheme {
    IngredientsListScreen(emptyList())
}
