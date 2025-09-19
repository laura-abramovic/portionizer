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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abramoviclaura.portionizer.R
import com.abramoviclaura.portionizer.entity.IngredientId
import com.abramoviclaura.portionizer.ui.components.AddButton
import com.abramoviclaura.portionizer.ui.components.IngredientListItem
import com.abramoviclaura.portionizer.ui.screens.RatioBottomSheet
import com.abramoviclaura.portionizer.ui.theme.LocalDimensionSystem
import com.abramoviclaura.portionizer.ui.theme.PortionizerTheme
import com.abramoviclaura.portionizer.ui.utils.appScreen
import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListRouter
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListViewModel
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.IngredientsListViewState
import com.abramoviclaura.portionizer.viewcontracts.ingredientslist.RatioBottomSheetViewState
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientsListScreen(
    router: IngredientsListRouter,
    viewModel: IngredientsListViewModel = koinViewModel(),
) {
    val ingredientsViewState by viewModel.ingredientsViewState().collectAsStateWithLifecycle(IngredientsListViewState.initial())
    val ratioBottomSheetViewState by viewModel.ratioBottomSheetViewState().collectAsStateWithLifecycle(RatioBottomSheetViewState(false))

    IngredientsListScreenRootContainer(
        ingredientsViewState = ingredientsViewState,
        ratioBottomSheetViewState = ratioBottomSheetViewState,
        onAddButtonClick = router::showAddIngredientScreen,
        onSplitPortionsButtonClick = viewModel::onSplitPortionsButtonClick,
        onEditIngredientButtonClick = viewModel::onEditIngredientButtonClick,
        onDeleteIngredientButtonClick = viewModel::onDeleteIngredientButtonClick,
        onSplitButtonClick = viewModel::onRatioBottomSheetSplitButtonClick,
        onCancelButtonClick = viewModel::onRatioBottomSheetDismiss,
        onDismissRatioSheet = viewModel::onRatioBottomSheetDismiss
    )
}

@Composable
private fun IngredientsListScreenRootContainer(
    ingredientsViewState: IngredientsListViewState,
    ratioBottomSheetViewState: RatioBottomSheetViewState,
    onAddButtonClick: () -> Unit,
    onSplitPortionsButtonClick: () -> Unit,
    onEditIngredientButtonClick: (IngredientId) -> Unit,
    onDeleteIngredientButtonClick: (IngredientId) -> Unit,
    onSplitButtonClick: (Int, Int) -> Unit,
    onCancelButtonClick: () -> Unit,
    onDismissRatioSheet: () -> Unit,
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

        if (ingredientsViewState.ingredients.isEmpty()) {
            IngredientListEmptyContent(onAddButtonClick = onAddButtonClick)
        } else {
            IngredientsListContent(
                ingredients = ingredientsViewState.ingredients,
                onAddButtonClick = onAddButtonClick,
                onSplitPortionsButtonClick = onSplitPortionsButtonClick,
                onEditClick = onEditIngredientButtonClick,
                onDeleteClick = onDeleteIngredientButtonClick
            )
        }
    }

    if (ratioBottomSheetViewState.visible) {
        RatioBottomSheet(
            onSplitButtonClick = onSplitButtonClick,
            onCancelButtonClick = onCancelButtonClick,
            onDismissRequest = onDismissRatioSheet
        )
    }
}

@Composable
private fun IngredientsListContent(
    ingredients: List<IngredientViewState>,
    onAddButtonClick: () -> Unit,
    onSplitPortionsButtonClick: () -> Unit,
    onEditClick: (IngredientId) -> Unit,
    onDeleteClick: (IngredientId) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        LazyColumn {
            items(ingredients) { ingredient ->
                IngredientListItem(
                    name = ingredient.name,
                    quantity = ingredient.quantity,
                    onEditClick = { onEditClick(ingredient.id) },
                    onDeleteClick = { onDeleteClick(ingredient.id) }
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
        IngredientViewState(IngredientId(""), "Carrot", "360"),
        IngredientViewState(IngredientId(""), "Red bell peper", "120"),
        IngredientViewState(IngredientId(""), "Olive oil", "6"),
        IngredientViewState(IngredientId(""), "Onion", "84"),
        IngredientViewState(IngredientId(""), "Rice", "80"),
        IngredientViewState(IngredientId(""), "Chicken", "500"),
    )

    IngredientsListScreenRootContainer(
        ingredientsViewState = IngredientsListViewState(ingredients),
        ratioBottomSheetViewState = RatioBottomSheetViewState(false),
        onAddButtonClick = {},
        onSplitPortionsButtonClick = {},
        onEditIngredientButtonClick = {},
        onDeleteIngredientButtonClick = {},
        onSplitButtonClick = { _, _ -> },
        onCancelButtonClick = {},
        onDismissRatioSheet = {}
    )
}

@Preview
@Composable
private fun PreviewIngredientsListEmptyScreen() = PortionizerTheme {
    IngredientsListScreenRootContainer(
        ingredientsViewState = IngredientsListViewState(emptyList()),
        ratioBottomSheetViewState = RatioBottomSheetViewState(false),
        onAddButtonClick = {},
        onSplitPortionsButtonClick = {},
        onEditIngredientButtonClick = {},
        onDeleteIngredientButtonClick = {},
        onSplitButtonClick = { _, _ -> },
        onCancelButtonClick = {},
        onDismissRatioSheet = {}
    )
}
