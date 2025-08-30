package com.abramoviclaura.portionizer.viewcontracts.ingredientslist

import androidx.lifecycle.ViewModel
import com.abramoviclaura.portionizer.viewcontracts.IngredientId
import com.abramoviclaura.portionizer.viewcontracts.IngredientViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class IngredientsListViewModel() : ViewModel() {

    private val ingredientsPublisher = MutableStateFlow<List<IngredientViewState>>(emptyList())

    fun ingredientsViewState() = ingredientsPublisher.map {
        IngredientsListViewState(it)
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
