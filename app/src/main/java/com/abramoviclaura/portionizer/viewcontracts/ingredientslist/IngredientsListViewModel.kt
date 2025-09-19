package com.abramoviclaura.portionizer.viewcontracts.ingredientslist

import androidx.lifecycle.ViewModel
import com.abramoviclaura.portionizer.entity.IngredientId
import com.abramoviclaura.portionizer.entity.Ratio
import com.abramoviclaura.portionizer.source.IngredientsListSource
import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class IngredientsListViewModel(
    private val ingredientsListSource: IngredientsListSource,
) : ViewModel() {

    private val ratioBottomSheetVisible = MutableStateFlow(false)

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

    fun ratioBottomSheetViewState() = ratioBottomSheetVisible.map(::RatioBottomSheetViewState)

    fun onSplitPortionsButtonClick() {
        ratioBottomSheetVisible.value = true
    }

    fun onRatioBottomSheetDismiss() {
        ratioBottomSheetVisible.value = false
    }

    fun onRatioBottomSheetSplitButtonClick(x: Int, y: Int) {
        ingredientsListSource.splitIngredients(Ratio(x, y))
    }

    fun onEditIngredientButtonClick(id: IngredientId) {
        // TODO
    }

    fun onDeleteIngredientButtonClick(id: IngredientId) {
        // TODO
    }
}
