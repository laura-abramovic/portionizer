package com.abramoviclaura.portionizer.viewcontracts.ingredientslist

import androidx.lifecycle.ViewModel
import com.abramoviclaura.portionizer.entity.IngredientId
import com.abramoviclaura.portionizer.source.IngredientsListSource
import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState
import kotlinx.coroutines.flow.map

class IngredientsListViewModel(
    private val ingredientsListSource: IngredientsListSource,
) : ViewModel() {

    fun ingredientsViewState() = ingredientsListSource.ingredientsList().map { ingredients ->
        IngredientsListViewState(
            ingredients.map {
                IngredientViewState(
                    id = it.id,
                    name = it.name,
                    quantity = it.grams.toString()
                )
            }
        )
    }

    fun onSplitPortionsButtonClick() {
        // TODO
    }

    fun onEditIngredientButtonClick(id: IngredientId) {
        // TODO
    }

    fun onDeleteIngredientButtonClick(id: IngredientId) {
        // TODO
    }
}
