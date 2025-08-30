package com.abramoviclaura.portionizer.viewcontracts

@JvmInline
value class IngredientId(val value: String)

data class IngredientViewState(
    val id: IngredientId,
    val name: String,
    val quantity: Int,
)
