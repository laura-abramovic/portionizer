package com.abramoviclaura.portionizer.viewcontracts.ingredientslist

import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState

data class IngredientsListViewState(
    val ingredients: List<IngredientViewState>,
) {
    companion object {
        fun initial() = IngredientsListViewState(emptyList())
    }
}

data class RatioBottomSheetViewState(val visible: Boolean)
