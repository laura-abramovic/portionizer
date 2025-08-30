package com.abramoviclaura.portionizer.viewcontracts

import com.abramoviclaura.portionizer.entity.IngredientId

data class IngredientViewState(
    val id: IngredientId,
    val name: String,
    val quantity: String,
)
